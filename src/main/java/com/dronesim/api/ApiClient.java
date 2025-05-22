package com.dronesim.api;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiClient {
    private final HttpClient client;
    private final String baseUrl;
    private final ApiConfig cfg;

    public ApiClient(ApiConfig cfg) {
        CookieManager cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        this.client = HttpClient.newBuilder()
            .cookieHandler(cookieManager)
            .followRedirects(Redirect.ALWAYS)
            .build();
        this.baseUrl = cfg.getBaseUrl();
        this.cfg = cfg;
    }
    // django login + saves session cookie
    public void login() throws Exception {
        HttpRequest getLogin = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + "/accounts/login/"))
            .GET()
            .build();
        String loginPage = client.send(getLogin, HttpResponse.BodyHandlers.ofString()).body();
        // CSRF extraction
        Pattern pattern = Pattern.compile("name=\"csrfmiddlewaretoken\" value=\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(loginPage);
        if (!matcher.find()) throw new RuntimeException("CSRF token nicht gefunden");
        String csrf = matcher.group(1);
        // formdata
        String form = "username=" + URLEncoder.encode(cfg.getUsername(), StandardCharsets.UTF_8)
                    + "&password=" + URLEncoder.encode(cfg.getPassword(), StandardCharsets.UTF_8)
                    + "&csrfmiddlewaretoken=" + URLEncoder.encode(csrf, StandardCharsets.UTF_8);
        // POST login
        HttpRequest postLogin = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + "/accounts/login/"))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .header("Referer", baseUrl + "/accounts/login/")
            .POST(HttpRequest.BodyPublishers.ofString(form))
            .build();
        HttpResponse<String> resp = client.send(postLogin, HttpResponse.BodyHandlers.ofString());
        int status = resp.statusCode();
        if (status < 200 || status >= 300) {
            throw new RuntimeException("Login fehlgeschlagen: HTTP " + resp.statusCode());
        }
        System.out.println(" login successfull, session-cookie aquired");
    }

    // executes get-request + delivers JSON-String
    public String getJson(String path) throws IOException, InterruptedException {
        System.out.println("DEBUG: Request URI = " + baseUrl + path);
        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + path))
            .GET()
            .build();
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        int status = resp.statusCode();
        if (status < 200 || status >= 300) {
            throw new RuntimeException("GET " + path + " → HTTP " + resp.statusCode());
        }
        return resp.body();
    }

    // executest POST-request with Json-body + delivers pure JSON-String
    public String postJson(String path, String jsonBody) throws IOException, InterruptedException {
        System.out.println("DEBUG: Request URI = " + baseUrl + path);
        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + path))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();
        
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        int status = resp.statusCode();
        if (status < 200 || status >= 300) {
            throw new RuntimeException("Post " + path + " to HTTP" + resp.statusCode());
        }
        return resp.body();
    }
}

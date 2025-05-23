package com.dronesim.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private final HttpClient client;
    private final String baseUrl;
    private final String token;

    public ApiClient(ApiConfig cfg) {
        this.client = HttpClient.newBuilder()
            .followRedirects(Redirect.ALWAYS)
            .build();
        this.baseUrl = cfg.getBaseUrl();
        this.token = cfg.getToken();
    }

    public String getJson(String path) throws IOException, InterruptedException {
        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + path))
            .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
            .GET()
            .build();
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        int status = resp.statusCode();
        if (status < 200 || status >= 300) {
            throw new RuntimeException("GET " + path + " -> HTTP " + status);
        }
        return resp.body();
    }

    public String postJson(String path, String jsonBody) throws IOException, InterruptedException {
        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + path))
            .header("Authorization", "Token " + token)
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        int status = resp.statusCode();
        if (status < 200 || status >= 300) {
            throw new RuntimeException("POST " + path + " → HTTP " + status);
        }
        return resp.body();
    }
}
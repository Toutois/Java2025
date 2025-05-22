package com.dronesim.api;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Properties;

public class ApiConfig {
    private final String baseUrl;
    private final String username;
    private final String password;
    private final String basicAuthHeader;
    
    public ApiConfig() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) 
                throw new RuntimeException("config.properties not found");
            Properties props = new Properties();
            props.load(in);
            this.baseUrl = props.getProperty("api.baseUrl");
            this.username = props.getProperty("api.username");
            this.password = props.getProperty("api.password");
            String cred = username + ":" + password;
            this.basicAuthHeader = Base64.getEncoder().encodeToString(cred.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException("Error while loading configuration", e);
        }
    }

    public String getBaseUrl() { return baseUrl; }
    public String getBasicAuthHeader() { return "Basic " + basicAuthHeader; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

}

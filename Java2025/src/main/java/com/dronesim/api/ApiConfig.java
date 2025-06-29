package com.dronesim.api;

public class ApiConfig {
    private final String baseUrl;
    private final String token;
    
    public ApiConfig(String baseUrl, String token) {
        // Ensure URL ends with slash and validate input
        if (baseUrl == null || token == null) {
            throw new IllegalArgumentException("Base URL and token cannot be null");
        }
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
        this.token = token;
    }

    public String getBaseUrl() { return baseUrl; }
    public String getToken() { return token; }
}
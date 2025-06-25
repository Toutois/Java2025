package com.dronesim.api;

import java.io.InputStream;
import java.util.Properties;

public class ApiConfig {
    private final String baseUrl;
    private final String token;
    
    // public ApiConfig(String baseUrl, String token) {
    //     this.baseUrl = baseUrl;
    //     this.token = token;
    // }

    public ApiConfig() {
        // load config.properties from classpath
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) throw new RuntimeException("config.propertoes not found");
            Properties props = new Properties();
            props.load(in);

            // read required properties
            this.baseUrl = props.getProperty("api.baseUrl");
            this.token = props.getProperty("api.token");

            if (baseUrl == null || token == null) {
                throw new RuntimeException("api.baseUrl o api.token missin in config.properties");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while loading configuration");
        }
    }

    public String getBaseUrl() { return baseUrl; }
    public String getToken() { return token; }
}
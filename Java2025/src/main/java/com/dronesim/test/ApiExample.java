package com.dronesim.test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import com.dronesim.api.ApiClient;
import com.dronesim.api.ApiConfig;

public class ApiExample {
    public static void main (String[] args) {
        try {
            // Replace with actual base URL and API key or credentials as required
            ApiConfig cfg = new ApiConfig("http://your-api-base-url", "your-api-key-or-credentials");
            ApiClient client = new ApiClient(cfg);

            // fetch drone list and save to file
            String dronesJson = client.getJson("/api/drones/?limit=100000&offset=0");
            Files.writeString(Path.of("drones.json"), dronesJson, StandardCharsets.UTF_8);
            System.out.println("drones.json saved (" + dronesJson.length() + " bytes)");

            // fetch drone types and save to file
            String typesJson = client.getJson("/api/dronetypes/?limit=100000&offset=0");
            Files.writeString(Path.of("dronetypes.json"), typesJson, StandardCharsets.UTF_8);
            System.out.println("dronetypes.json saved (" + typesJson.length() + " bytes)");

            // fetch dynamics data and save to file
            String dynamicsJson = client.getJson("/api/dronedynamics/?limit=100000&offset=0");
            Files.writeString(Path.of("dynamics.json"), dynamicsJson, StandardCharsets.UTF_8);
            System.out.println("dynamics.json saved (" + dynamicsJson.length() + " bytes)");
            
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
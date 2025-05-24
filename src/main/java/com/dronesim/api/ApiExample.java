package com.dronesim.api;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class ApiExample {
    public static void main (String[] args) {
        try {
            ApiConfig cfg = new ApiConfig();
            ApiClient client = new ApiClient(cfg);

            String dronesJson = client.getJson("/api/drones/?limit=100&offset=0");
            Files.writeString(Path.of("drones.json"), dronesJson, StandardCharsets.UTF_8);
            System.out.println("drones.json saved (" + dronesJson.length() + " bytes)");

            String typesJson = client.getJson("/api/dronetypes/?limit=100&offset=0");
            Files.writeString(Path.of("dronetypes.json"), typesJson, StandardCharsets.UTF_8);
            System.out.println("dronestypes.json saved (" + typesJson.length() + " bytes)");

            String dynamicsJson = client.getJson("/api/dronedynamics/?limit=100&offset=0");
            Files.writeString(Path.of("dynamics.json"), dynamicsJson, StandardCharsets.UTF_8);
            System.out.println("dynamics.json saved (" + dynamicsJson.length() + " bytes)");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
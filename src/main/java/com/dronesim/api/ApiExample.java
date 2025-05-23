package com.dronesim.api;

public class ApiExample {
    public static void main (String[] args) {
        try {
            ApiConfig cfg = new ApiConfig();
            ApiClient client = new ApiClient(cfg);

            String dronesJson = client.getJson("/api/drones/?limit=100&offset=0");
            System.out.println("Drones JSON:\n" + dronesJson);

            String typesJson = client.getJson("/api/dronetypes/?limit=100&offset=0");
            System.out.println("Dronetypes JSON:\n" + typesJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
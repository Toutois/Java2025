package com.dronesim.api;

public class ApiExample {
    public static void main (String[] args) {
        try {
            ApiConfig cfg = new ApiConfig();
            ApiClient client = new ApiClient(cfg);

            String dronesJson = client.getJson("/api/drones/");
            System.out.println("Dronetypes JSON:\n" + dronesJson);

            String payload = "{\"id\":999,\"typename\":\"TestDrone\"}";
            String result  = client.postJson("/api/dronetypes/", payload);
            System.out.println("POST response:\n" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
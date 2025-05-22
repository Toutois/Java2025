package com.dronesim.api;

public class ApiExample {
    public static void main(String[] args) {
        try {
            ApiConfig cfg = new ApiConfig();
            System.out.println(">> LOADED baseUrl = [" + cfg.getBaseUrl() + "]");
            ApiClient client = new ApiClient(cfg);
            client.login();

            String DronesOverviewJson = client.getJson("/simulator/drones/");
            System.out.println("Response GET 'Drones Overview' /simulator/drones/: \n" + DronesOverviewJson);

            String newDrone = "{" +
                "\"id\":\"drone-123\"," +
                "\"lat\":48.1351," +
                "\"lon\":11.5820" +
                "}";
            String createJson = client.postJson("/simulator/drones/", newDrone);
            System.out.println("Response POST 'Drones Overview' /simulator/drones/ :\n" + createJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

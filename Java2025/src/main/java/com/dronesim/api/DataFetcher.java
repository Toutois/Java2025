package com.dronesim.api;

import java.io.IOException;

public class DataFetcher {
    private final ApiClient apiClient;
    private static final String DRONE_TYPES_ENDPOINT = "api/dronetypes/"; // No leading slash!

    public DataFetcher(ApiConfig config) {
        this.apiClient = new ApiClient(config);
    }

    public String fetchDroneTypes() throws IOException, InterruptedException {
        // Add format=json and proper pagination
        return apiClient.getJson(DRONE_TYPES_ENDPOINT + "?limit=100&format=json");
    }
}
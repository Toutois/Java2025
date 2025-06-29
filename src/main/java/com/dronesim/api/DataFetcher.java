package com.dronesim.api;

import com.dronesim.model.DroneDynamics;
import com.dronesim.parser.ManualJsonParser;
import com.dronesim.api.DataFetcher;

import java.net.URI;

import java.util.List;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;


public class DataFetcher {
    private final ApiClient client;
    private final ManualJsonParser parser;

    public DataFetcher() {
        ApiConfig cfg = new ApiConfig();
        this.client = new ApiClient(cfg);
        this.parser = new ManualJsonParser();
    }


    /*
     * @param limit, number of entries to fetch
     * @param offset, offset for pagination
     * @param List of parsed DroneDynamics objects
    */

    public List<DroneDynamics> fetchDroneDynamics(int limit, int offset) throws Exception {
        String path = "/api/dronedynamics/?limit=" + limit + "&offset=" + offset;
        String json = client.getJson(path);
        return parser.parseDynamics(json);
    }

    /*
    public void fetchDroneDynamicsWithPagination() throws Exception, InterruptedException {
        String path = "/api/dronedynamics/?limit=20&offset=0";  // Start-URL

        while (path != null) {
            String jsonResponse = client.getJson(path);
            List<DroneDynamics> droneDynamics = new ManualJsonParser().parseDynamics(jsonResponse);
            droneDynamics.forEach(System.out::println);
            path = extractNextPageUrl(jsonResponse);

        }
    }
    */

    private String extractNextPageUrl(String jsonResponse) {
        try {
            JSONObject json = new JSONObject(jsonResponse);
            if (json.has("next") && json.getString("next") != null) {
                return json.getString("next");
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void fetchDroneDynamicsWithPaginationConfirmation(int limit, int droneId) throws Exception {
        Scanner scanner = new Scanner(System.in);
        try{
            String path = "/api/" + droneId + "/dynamics/?limit=" + limit + "&offset=0";

            while (path != null) {
                // Debug
                System.out.println("DEBUG " + path);

                String json = client.getJson(path);
                
                // List<DroneDynamics> page = parser.parseDynamics(json);
                parser.parseDynamics(json).forEach(System.out::println);
                
                // page.forEach(System.out::println);

                String nextRaw = new JSONObject(json).optString("next", null);

                if (nextRaw == null || nextRaw.isEmpty()) {
                    path = null;
                } else {
                    System.out.print("Load next page? (y/n) ");
                    String answer = scanner.nextLine().trim();
                    if (!answer.equalsIgnoreCase("y")) {
                        break;
                    }
                    URI nextUri = URI.create(nextRaw);
                    String rel = nextUri.getPath() + (nextUri.getQuery() != null ? "?" + nextUri.getQuery():"");
                    System.out.println("Using relative path: " + rel);
                    path = rel;
                }
            }    
        } finally {
            scanner.close();
        }
    }


    public List<DroneDynamics> fetchDroneDynamicsForDrone(int droneId, int limit, int offset) throws Exception {
        String path = "/api/" + droneId + "/dynamics/?limit=" + limit + "&offset=" + offset;
        String json = client.getJson(path);
        return parser.parseDynamics(json);
    }

}
package com.dronesim.test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.dronesim.api.ApiClient;
import com.dronesim.api.ApiConfig;
import com.dronesim.model.DroneDynamics;
import com.dronesim.api.DataFetcher;

public class ApiExample {
    public static void main (String[] args) {
      //  try {
        //    DataFetcher dataFetcher = new DataFetcher();
          //  dataFetcher.fetchDroneDynamicsWithPagination();

//        } catch (Exception e) {
  //          System.err.println("Fehler beim Laden der DroneDynamics: " + e.getMessage());
    //        e.printStackTrace();
      //  }
        
        try {
            ApiConfig cfg = new ApiConfig();
            ApiClient client = new ApiClient(cfg);

            // fetch drone list and save to file
            // String dronesJson = client.getJson("/api/drones/?limit=100000&offset=0");
            // Files.writeString(Path.of("drones.json"), dronesJson, StandardCharsets.UTF_8);
            // System.out.println("drones.json saved (" + dronesJson.length() + " bytes)");

            // fetch drone types and save to file
            // String typesJson = client.getJson("/api/dronetypes/?limit=100000&offset=0");
            // Files.writeString(Path.of("dronetypes.json"), typesJson, StandardCharsets.UTF_8);
            // System.out.println("dronetypes.json saved (" + typesJson.length() + " bytes)");

            // fetch dynamics data and save to file
            // String dynamicsJson = client.getJson("/api/dronedynamics/?limit=1&offset=0");
            // Files.writeString(Path.of("dynamics.json"), dynamicsJson, StandardCharsets.UTF_8);
            // System.out.println("dynamics.json saved (" + dynamicsJson.length() + " bytes)");

            
            //String dynamicsJson = client.getJson("/api/dronedynamics/31/?limit=10&offset=0");
            //Files.writeString(Path.of("dynamics.json"), dynamicsJson, StandardCharsets.UTF_8);            
            //System.out.println("dynamics.json saved (" + dynamicsJson.length() + " bytes)");
            

            DataFetcher dataFetcher = new DataFetcher();
            System.out.println(dataFetcher.fetchDroneDynamics(31,10, 0));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 
package com.dronesim.model;

import java.util.List;

import com.dronesim.api.DataFetcher;

public class DroneDynamicsDataProvider implements PagedDataProvider<DroneDynamics> {
    private final DataFetcher fetcher = new DataFetcher();
    private final int droneId;

    public DroneDynamicsDataProvider() {
        this.droneId = -1; // Special value indicating "no specific drone"
    }

   public DroneDynamicsDataProvider(int droneId) {
        this.droneId = droneId;
    }

    @Override
    public List<DroneDynamics> getPage(int pageIndex, int pageSize) throws Exception {
        int offset = pageIndex * pageSize;
        if (droneId == -1) {
            return fetcher.fetchAllDroneDynamics(pageSize, offset);
        } else {
            return fetcher.fetchDroneDynamics(droneId, pageSize, offset);
        }
    }
}

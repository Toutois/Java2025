package com.dronesim.model;

import java.util.List;

public interface PagedDataProvider {
    List<String[]> getPageData(int pageIndex, int pageSize);
}

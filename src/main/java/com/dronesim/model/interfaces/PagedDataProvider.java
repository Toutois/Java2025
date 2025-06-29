package com.dronesim.model.interfaces;

import java.util.List;

public interface PagedDataProvider {
    List<String[]> getPageData(int pageIndex, int pageSize);
}

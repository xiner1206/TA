package com.ta.framework.entity.Vo;

import java.util.List;

public class Ids {
    List<Integer> storeIds;

    public Ids() {
    }

    public Ids(List<Integer> storeIds) {
        this.storeIds = storeIds;
    }

    public List<Integer> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<Integer> storeIds) {
        this.storeIds = storeIds;
    }
}

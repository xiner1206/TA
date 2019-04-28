package com.ta.framework.service;

import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Store;

public interface StoreService {

    public Page<Store> select(Page<Store> storePage);

    public int countByPage(Page<Store> storePage);

    public int addAndUpdateStore(Store store);
}

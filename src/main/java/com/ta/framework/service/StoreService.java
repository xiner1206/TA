package com.ta.framework.service;

import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Store;
import com.ta.framework.entity.Trade;

import java.util.List;

public interface StoreService {

    Page<Store> select(Page<Store> storePage);

    int countByPage(Page<Store> storePage);

    int addAndUpdateStore(Store store);

    Page<Store> selectOnePic(Page<Store> page);

    Store selectById(Store store);

    List<Store> hotSearch(Trade trade);
}

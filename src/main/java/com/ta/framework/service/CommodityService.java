package com.ta.framework.service;

import com.ta.framework.entity.Commodity;
import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Store;

import java.util.List;

public interface CommodityService {

    public int addAndUpdateCommodity(Commodity commodity);

    public Page<Commodity> select(Page<Commodity> page);

    public int countByPage(Page<Commodity> page);

    Page<Commodity> selectOnePic(Page<Commodity> page);

    Commodity selectById(Commodity commodity);

    List<Commodity> sameName(Commodity commodity);

    List<Commodity> hotSearch(Store store);
}

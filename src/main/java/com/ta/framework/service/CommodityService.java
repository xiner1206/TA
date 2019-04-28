package com.ta.framework.service;

import com.ta.framework.entity.Commodity;
import com.ta.framework.entity.Dto.Page;

public interface CommodityService {

    public int addAndUpdateCommodity(Commodity commodity);

    public Page<Commodity> select(Page<Commodity> page);

    public int countByPage(Page<Commodity> page);
}

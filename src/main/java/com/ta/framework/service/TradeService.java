package com.ta.framework.service;

import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Trade;


public interface TradeService {
    public Page<Trade> select(Page<Trade> tradePage);

    public int countByPage(Page<Trade> tradePage);

    public int addAndUpdateTrade(Trade trade);
}

package com.ta.framework.service;

import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Trade;
import com.ta.framework.entity.Vo.tradeOnePic;


public interface TradeService {
    public Page<Trade> select(Page<Trade> tradePage);

    public int countByPage(Page<Trade> tradePage);

    public int addAndUpdateTrade(Trade trade);

    Page<Trade> selectOnePic(Page<Trade> page);
}

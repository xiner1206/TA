package com.ta.framework.dao;

import com.ta.framework.dao.util.GenericDao;
import com.ta.framework.dao.util.PageDao;
import com.ta.framework.entity.Trade;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeDao extends GenericDao<Trade>,PageDao<Trade> {
}

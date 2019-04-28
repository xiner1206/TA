package com.ta.framework.dao;

import com.ta.framework.dao.util.GenericDao;
import com.ta.framework.dao.util.PageDao;
import com.ta.framework.entity.Commodity;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityDao extends GenericDao<Commodity>,PageDao<Commodity> {
}

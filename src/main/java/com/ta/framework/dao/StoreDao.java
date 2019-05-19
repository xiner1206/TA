package com.ta.framework.dao;

import com.ta.framework.dao.util.GenericDao;
import com.ta.framework.dao.util.PageDao;
import com.ta.framework.entity.Store;
import com.ta.framework.entity.Trade;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StoreDao extends GenericDao<Store>,PageDao<Store> {

    Integer storeSum();

    Integer storeType(@Param(value = "typeName") String typeName);

    List<Store> hotSearch(@Param(value = "pojo") Trade trade);
}

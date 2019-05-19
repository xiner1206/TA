package com.ta.framework.dao;

import com.ta.framework.dao.util.GenericDao;
import com.ta.framework.dao.util.PageDao;
import com.ta.framework.entity.Commodity;
import com.ta.framework.entity.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityDao extends GenericDao<Commodity>,PageDao<Commodity> {

    Integer commoditySum();

    List<Commodity> hotSearch(@Param("pojo") Store store);

    List<Commodity> sameName(@Param("pojo") Commodity commodity);


}

package com.ta.framework.dao;

import com.ta.framework.dao.util.GenericDao;
import com.ta.framework.dao.util.PageDao;
import com.ta.framework.entity.Activity;
import com.ta.framework.entity.Dto.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityDao<T> extends GenericDao<Activity>,PageDao<Activity> {

    Integer countTradeAc(@Param("page") Page<T> page);

    List<T> pageTradeAc(@Param("page") Page<T> page);
}

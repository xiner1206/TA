package com.ta.framework.dao.util;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenericDao<T> {

    Integer insert(@Param("pojo") T pojo);
    Integer update(@Param("pojo") T pojo);
    Integer delete(@Param("pojo") T pojo);
    List<T> select(@Param("pojo") T pojo);
    T selectById(@Param("id") Integer id);
}

package com.ta.framework.dao.util;

import com.ta.framework.entity.Dto.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageDao<T> {

    Integer countByPage(@Param("page") Page<T> page);

    List<T> selectByPage(@Param("page") Page<T> page);
}

package com.ta.framework.dao;

import com.ta.framework.entity.Score;
import com.ta.framework.entity.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreDao {

    Integer insert(@Param("pojo") Score pojo);

    Score avgScore(@Param("pojo") Store store);
}

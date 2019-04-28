package com.ta.framework.dao;

import com.ta.framework.dao.util.GenericDao;
import com.ta.framework.dao.util.PageDao;
import com.ta.framework.entity.Activity;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityDao extends GenericDao<Activity>,PageDao<Activity> {
}

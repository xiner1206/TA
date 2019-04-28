package com.ta.framework.dao;

import com.ta.framework.dao.util.GenericDao;
import com.ta.framework.dao.util.PageDao;
import com.ta.framework.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends GenericDao<User>,PageDao<User> {

}

package com.ta.framework.controller;

import com.ta.framework.dao.UserDao;
import com.ta.framework.entity.Dto.Result;
import com.ta.framework.entity.User;
import com.ta.framework.util.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="/user/login", method = RequestMethod.POST)
    @ResponseBody
    public Result<User> userLogin(@RequestBody User user){
        List<User> users = userDao.select(user);
        if (users != null &&users.size() == 1){
            User u = users.get(0);
            UserSession.setUser(u);
            return new Result<>("success",u);

        }
        else
            return new Result<>("fail");
    }

    @RequestMapping(value = "/user/save",method = RequestMethod.POST)
    @ResponseBody
    public Result<User> userSava(@RequestBody User user){
        List<User> users = userDao.select(new User(user.getUserNum()));
        if(users.size() != 0)
            return new Result<>("fail");
        userDao.insert(user);
        return new Result<>("success",user);
    }

    @RequestMapping(value = "/user/logout",method = RequestMethod.GET)
    @ResponseBody
    public String userLogout(){
        UserSession.removeUser();
        return "OK";
    }

    @RequestMapping(value = "/user/test",method = RequestMethod.GET)
    @ResponseBody
    public User userTest(){
        return UserSession.getUser();
    }
}

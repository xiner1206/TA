package com.ta.framework.controller;

import com.ta.framework.dao.StoreDao;
import com.ta.framework.dao.TradeDao;
import com.ta.framework.dao.UserDao;
import com.ta.framework.entity.Dto.Result;
import com.ta.framework.entity.Store;
import com.ta.framework.entity.Trade;
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

    @Autowired
    private StoreDao storeDao;

    @Autowired
    private TradeDao tradeDao;

    @RequestMapping(value="/user/login", method = RequestMethod.POST)
    @ResponseBody
    public Result<User> userLogin(@RequestBody User user){
        List<User> users = userDao.select(user);
        if (users != null &&users.size() == 1){
            User u = users.get(0);
            u.setTosId(getTosId(u));
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

    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    @ResponseBody
    public Integer userUpdate(@RequestBody User user){
        return userDao.update(user);
    }

    public Integer getTosId(User user){
        if(user.getUserState()==2 ){
            Trade trade = new Trade();
            trade.setUser(user);
            List<Trade> select = tradeDao.select(trade);
            return select.get(0).getTradeId();
        }else if(user.getUserState()==3){
            Store store = new Store();
            store.setUser(user);
            List<Store> select = storeDao.select(store);
            return select.get(0).getStoreId();
        }else{
            return 0;
        }
    }
}

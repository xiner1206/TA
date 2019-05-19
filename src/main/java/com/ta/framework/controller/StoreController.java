package com.ta.framework.controller;

import com.ta.framework.dao.StoreDao;
import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Store;
import com.ta.framework.entity.Trade;
import com.ta.framework.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private StoreDao storeDao;

    @RequestMapping(value = "/store/page",method = RequestMethod.POST)
    @ResponseBody
    public Page<Store> page(@RequestBody Page<Store> storePage){
        return storeService.select(storePage);
    }

    @RequestMapping(value = "/store/addOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    public Integer addAndUpdateStore(@RequestBody Store store){
        return storeService.addAndUpdateStore(store);
    }

    @RequestMapping(value = "/store/onePic",method = RequestMethod.POST)
    @ResponseBody
    public Page<Store> onePic(@RequestBody Page<Store> page){
        return storeService.selectOnePic(page);
    }

    @RequestMapping(value = "/store/selectById",method = RequestMethod.POST)
    @ResponseBody
    public Store selectById(@RequestBody Store store){
        return storeService.selectById(store);
    }

    @RequestMapping(value = "/store/hotSearch",method = RequestMethod.POST)
    @ResponseBody
    public List<Store> hotSearch(@RequestBody Trade trade){
        return storeService.hotSearch(trade);
    }
}

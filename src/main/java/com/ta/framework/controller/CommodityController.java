package com.ta.framework.controller;

import com.ta.framework.entity.Activity;
import com.ta.framework.entity.Commodity;
import com.ta.framework.entity.Dto.Page;
import com.ta.framework.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "/commodity/addOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    public Integer addAndUpdateCommodity(@RequestBody Commodity commodity){
        return commodityService.addAndUpdateCommodity(commodity);
    }

    @RequestMapping(value = "/commodity/page",method = RequestMethod.POST)
    @ResponseBody
    public Page<Commodity> page(@RequestBody Page<Commodity> commodity) {
        return  commodityService.select(commodity);
    }

}

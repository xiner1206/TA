package com.ta.framework.controller;

import com.ta.framework.dao.CommodityDao;
import com.ta.framework.entity.Activity;
import com.ta.framework.entity.Commodity;
import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Store;
import com.ta.framework.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;
    @Autowired
    private CommodityDao commodityDao;

    @RequestMapping(value = "/commodity/addOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    public Integer addAndUpdateCommodity(@RequestBody Commodity commodity){
        return commodityService.addAndUpdateCommodity(commodity);
    }

    @RequestMapping(value = "/commodity/page",method = RequestMethod.POST)
    @ResponseBody
    public Page<Commodity> page(@RequestBody Page<Commodity> commodity) {
        if(commodity.getCondition()!=null&&commodity.getCondition().getPriceInterval()!=null){
            commodity.getCondition().setStartPrice(commodity.getCondition().getPriceInterval().get(0));
            commodity.getCondition().setEndPrice(commodity.getCondition().getPriceInterval().get(1));
            if(commodity.getCondition().getStartPrice().compareTo(commodity.getCondition().getEndPrice())==1){
                commodity.getCondition().setStartPrice(commodity.getCondition().getPriceInterval().get(1));
                commodity.getCondition().setEndPrice(commodity.getCondition().getPriceInterval().get(0));
            }
        }
        return  commodityService.select(commodity);
    }

    @RequestMapping(value = "/commodity/onePic",method = RequestMethod.POST)
    @ResponseBody
    public Page<Commodity> onePic(@RequestBody Page<Commodity> commodityPage){
        return commodityService.selectOnePic(commodityPage);
    }

    @RequestMapping(value = "/commodity/selectById",method = RequestMethod.POST)
    @ResponseBody
    public Commodity selectById(@RequestBody Commodity commodity){
        return commodityService.selectById(commodity);
    }

    @RequestMapping(value = "/commodity/hotSearch",method = RequestMethod.POST)
    @ResponseBody
    public List<Commodity> hotSearch(@RequestBody Store store){
        return commodityService.hotSearch(store);
    }

    @RequestMapping(value = "/commodity/sameName",method = RequestMethod.POST)
    @ResponseBody
    public List<Commodity> sameName(@RequestBody Commodity commodity){
        return commodityService.sameName(commodity);
    }


}

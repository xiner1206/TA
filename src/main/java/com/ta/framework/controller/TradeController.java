package com.ta.framework.controller;

import com.ta.framework.dao.TradeDao;
import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Trade;
import com.ta.framework.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @Autowired
    private TradeDao tradeDao;

    @RequestMapping(value = "/trade/page",method = RequestMethod.POST)
    @ResponseBody
    public Page<Trade> page(@RequestBody Page<Trade> tradePage){
        return tradeService.select(tradePage);
    }

    @RequestMapping(value = "/trade/addOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    public Integer addAndUpdateTrade(@RequestBody Trade trade){
         return tradeService.addAndUpdateTrade(trade);
    }

    @RequestMapping(value = "/trade/onePic",method = RequestMethod.POST)
    @ResponseBody
    public Page<Trade> onePic(@RequestBody Page<Trade> tradePage){
        return tradeService.selectOnePic(tradePage);
    }


    @RequestMapping(value = "/trade/selectById",method = RequestMethod.POST)
    @ResponseBody
    public Trade selectById(@RequestBody Trade trade){
        return tradeService.selectById(trade);
    }

    @RequestMapping(value = "/trade/hotSearch",method = RequestMethod.POST)
    @ResponseBody
    public List<Trade> hotSearch(){
        return tradeService.hotSearch();
    }
}

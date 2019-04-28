package com.ta.framework.controller;

import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Trade;
import com.ta.framework.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TradeController {

    @Autowired
    private TradeService tradeService;

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

}

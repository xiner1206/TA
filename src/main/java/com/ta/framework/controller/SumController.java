package com.ta.framework.controller;


import com.ta.framework.dao.ActivityDao;
import com.ta.framework.dao.CommodityDao;
import com.ta.framework.dao.StoreDao;
import com.ta.framework.dao.TradeDao;
import com.ta.framework.entity.Vo.SumData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SumController {

    @Autowired
    private TradeDao tradeDao;
    @Autowired
    private StoreDao storeDao;
    @Autowired
    private CommodityDao commodityDao;
    @Autowired
    private ActivityDao activityDao;

    @RequestMapping(value = "/countSum", method = RequestMethod.POST)
    @ResponseBody
    public List<SumData> CountSum() {
        List<SumData> sumDatas = new ArrayList<>();
        SumData trade = new SumData();
        trade.setName("商圈");
        trade.setSum(tradeDao.tradeSum());
        sumDatas.add(trade);

        SumData store = new SumData();
        store.setName("店铺");
        store.setSum(storeDao.storeSum());
        sumDatas.add(store);

        SumData commodity = new SumData();
        commodity.setName("商品");
        commodity.setSum(commodityDao.commoditySum());
        sumDatas.add(commodity);

        SumData activity = new SumData();
        activity.setName("活动");
        activity.setSum(activityDao.activitySum());
        sumDatas.add(activity);

        String[] name={"美食","服饰","美妆","电影/演出","酒店住宿","休闲娱乐","其他"};
        for(int i=0;i<name.length;i++){
            SumData typeSum = new SumData();
            typeSum.setName(name[i]);
            typeSum.setSum(storeDao.storeType(name[i]));
            sumDatas.add(typeSum);
        }
        return sumDatas;
    }
}

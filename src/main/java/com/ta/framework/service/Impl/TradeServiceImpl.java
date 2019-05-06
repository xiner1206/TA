package com.ta.framework.service.Impl;

import com.ta.framework.dao.PictureDao;
import com.ta.framework.dao.TradeDao;
import com.ta.framework.dao.UserDao;
import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Picture;
import com.ta.framework.entity.Trade;
import com.ta.framework.entity.User;
import com.ta.framework.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeDao tradeDao;

    @Autowired
    private PictureDao pictureDao;

    @Autowired
    private UserDao userDao;


    @Override
    public Page<Trade> select(Page<Trade> page) {
        assert page.getPageSize() > 0;
        if(page.getCondition() == null) {
            page.setCondition(new Trade());
        }
        if(page.getPageNum() == null || page.getPageNum() <= 0) {
            page.setPageNum(1);
        }
        page.setTotalRecord(countByPage(page));
        Page<Trade> pg = new Page<>(page.getPageNum(),page.getPageSize(),page.getTotalRecord());
        pg.setCondition(page.getCondition());
        List<Trade> tradeList = tradeDao.selectByPage(pg);
        for (Trade trade:tradeList) {
            List<Integer> picIdList = trade.getTradePicIdList();
            List<Picture> tradePicList = new ArrayList<>();
            for (Integer picId: picIdList) {
                tradePicList.add(pictureDao.selectById(picId));
            }
            trade.setTradePicList(tradePicList);
        }
        pg.setList(tradeList);
        return pg;
    }

    @Override
    public int countByPage(Page<Trade> page) {
        assert page.getPageSize() > 0;
        if(page.getCondition() == null) {
            page.setCondition(new Trade());
        }
        if(page.getPageNum() == null || page.getPageNum() <= 0) {
            page.setPageNum(1);
        }

        return tradeDao.countByPage(page);
    }

    @Override
    public int addAndUpdateTrade(Trade trade) {
        List<Integer> tradeIdList = new ArrayList<>();
        trade.setTradePicIdList(tradeIdList);
        tradeIdList.clear();
        tradeIdList.addAll(getPicIdList(trade));
        if(trade.getTradeId() == null || trade.getTradeId() == 0) {
            addUser(trade);
            return tradeDao.insert(trade);
        }
        else{
            addUser(trade);
            return tradeDao.update(trade);
        }

    }

    public int  addUser(Trade trade){
        if(trade.getUser()!=null ) {
            List<User> users = userDao.select(new User(trade.getUser().getUserNum()));
            if (users.size() != 0)
                return 0;
            else {
                trade.getUser().setUserState(2);
                return userDao.insert(trade.getUser());
            }
        }else{
            return 0;
        }
    }

    public List<Integer> getPicIdList(Trade trade){
        List<Integer> listid = new ArrayList<>();
        for(Picture picture:trade.getTradePicList()){
            listid.add(picture.getPictureId());
            pictureDao.update(picture);
        }
        return  listid;
    }
}

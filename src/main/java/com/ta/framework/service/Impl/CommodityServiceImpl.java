package com.ta.framework.service.Impl;

import com.ta.framework.dao.CommodityDao;
import com.ta.framework.dao.PictureDao;
import com.ta.framework.entity.Commodity;
import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Picture;
import com.ta.framework.entity.Store;
import com.ta.framework.service.CommodityService;
import com.ta.framework.util.SameName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;
    @Autowired
    private PictureDao pictureDao;

    @Override
    public int addAndUpdateCommodity(Commodity commodity) {
        if(commodity.getCommodityPicList()!=null) {
            List<Integer> commodityIdList = new ArrayList<>();
            commodity.setCommodityPicIdList(commodityIdList);
            commodityIdList.clear();
            commodityIdList.addAll(getPicIdList(commodity));
        }
        if(commodity.getCommodityId() == null || commodity.getCommodityId() == 0)
            return commodityDao.insert(commodity);
        else
            return commodityDao.update(commodity);
    }

    @Override
    public Page<Commodity> selectOnePic(Page<Commodity> page) {
        assert page.getPageSize() > 0;
        if(page.getCondition() == null) {
            page.setCondition(new Commodity());
        }
        if(page.getPageNum() == null || page.getPageNum() <= 0) {
            page.setPageNum(1);
        }
        page.setTotalRecord(countByPage(page));
        Page<Commodity> pg = new Page<>(page.getPageNum(),page.getPageSize(),page.getTotalRecord());
        page.getCondition().setCommodityState(1);
        pg.setCondition(page.getCondition());
        List<Commodity> commodityList = commodityDao.selectByPage(pg);
        for (Commodity commodity:commodityList) {
            List<Integer> picIdList = commodity.getCommodityPicIdList();
            List<Picture> commodityPicList = new ArrayList<>();
            for (Integer picId: picIdList) {
                commodityPicList.add(pictureDao.selectById(picId));
            }
            commodity.setStoreId(commodity.getStore().getStoreId());
            commodity.setStore(null);
            commodity.setUrl(commodityPicList.get(0).getUrl());
//            if (commodity.getDiscountAc() != null && commodity.getDiscountAc().getActivityDiscount() != 10) {
//                if(new Date().after(commodity.getDiscountAc().getCreateTime())&& new Date().before(commodity.getDiscountAc().getEndTime())) {
//                    BigDecimal discount = BigDecimal.valueOf((float) commodity.getDiscountAc().getActivityDiscount() / 10);
//                    BigDecimal discountPrice = commodity.getCommodityPrice().multiply(discount);
//                    commodity.setDiscountPrice(discountPrice);
//                } else
//                    commodity.setDiscountPrice(null);
//            }
        }
        pg.setList(commodityList);
        return pg;
    }

    @Override
    public Page<Commodity> select(Page<Commodity> page) {
        assert page.getPageSize() > 0;
        if(page.getCondition() == null) {
            page.setCondition(new Commodity());
        }
        if(page.getPageNum() == null || page.getPageNum() <= 0) {
            page.setPageNum(1);
        }
        page.setTotalRecord(countByPage(page));
        Page<Commodity> pg = new Page<>(page.getPageNum(),page.getPageSize(),page.getTotalRecord());
        pg.setCondition(page.getCondition());
        List<Commodity> commodityList = commodityDao.selectByPage(pg);
        for (Commodity commodity:commodityList) {
            List<Integer> picIdList = commodity.getCommodityPicIdList();
            List<Picture> commodityPicList = new ArrayList<>();
            for (Integer picId: picIdList) {
                commodityPicList.add(pictureDao.selectById(picId));
            }
            commodity.setCommodityPicList(commodityPicList);
            if (commodity.getDiscountAc() != null && commodity.getDiscountAc().getActivityDiscount() != 10) {
                if(new Date().after(commodity.getDiscountAc().getCreateTime())&& new Date().before(commodity.getDiscountAc().getEndTime())) {

                    BigDecimal discount = BigDecimal.valueOf((float) commodity.getDiscountAc().getActivityDiscount() / 10);
                    BigDecimal discountPrice = commodity.getCommodityPrice().multiply(discount);
                    commodity.setDiscountPrice(discountPrice);
                } else
                    commodity.setDiscountPrice(null);
            }
        }
        pg.setList(commodityList);
        return pg;
    }

    @Override
    public int countByPage(Page<Commodity> page) {
        assert page.getPageSize() > 0;
        if(page.getCondition() == null) {
            page.setCondition(new Commodity());
        }
        if(page.getPageNum() == null || page.getPageNum() <= 0) {
            page.setPageNum(1);
        }
        return commodityDao.countByPage(page);
    }

    public List<Integer> getPicIdList(Commodity commodity){
        List<Integer> listid = new ArrayList<>();
        if(commodity.getCommodityPicList()!=null) {
            for (Picture picture : commodity.getCommodityPicList()) {
                listid.add(picture.getPictureId());
                pictureDao.update(picture);
            }
        }
        return  listid;
    }

    @Override
    public Commodity selectById(Commodity commodity) {
        Commodity commodity_rs = commodityDao.selectById(commodity.getCommodityId());
        List<Integer> picIdList = commodity_rs.getCommodityPicIdList();
        List<Picture> commodityPicList = new ArrayList<>();
        for (Integer picId: picIdList) {
            commodityPicList.add(pictureDao.selectById(picId));
        }
        commodity_rs.setCommodityPicList(commodityPicList);
        Integer hotNum = commodity_rs.getHotNum();
        commodity_rs.setHotNum(hotNum+1);
        commodityDao.update(commodity_rs);
        return commodity_rs;
    }

    @Override
    public List<Commodity> sameName(Commodity commodity) {
        Commodity commodity_demo = new Commodity();
        commodity_demo.setCommodityId(commodity.getCommodityId());
        List<Commodity> commodity_r= new ArrayList<>();
        for(int i=commodity.getCommodityName().length();i>0;i--) {
            List<String> rsList =SameName.getStrList(commodity.getCommodityName(), i);
            for (String name : rsList) {
                commodity_demo.setCommodityName(name);
                List<Commodity> commodities = commodityDao.sameName(commodity_demo);
                commodity_r.addAll(commodities);
            }
        }
        for (Commodity commodity_1 : commodity_r) {
            List<Integer> picIdList = commodity_1.getCommodityPicIdList();
            List<Picture> commodityPicList = new ArrayList<>();
            for (Integer picId : picIdList) {
                commodityPicList.add(pictureDao.selectById(picId));
            }
            commodity_1.setUrl(commodityPicList.get(0).getUrl());
        }
        return removeDuplicateWithOrder(commodity_r);
    }

    @Override
    public List<Commodity> hotSearch(Store store) {
        List<Commodity> commodities = commodityDao.hotSearch(store);
        for (Commodity commodity : commodities) {
            List<Integer> picIdList = commodity.getCommodityPicIdList();
            List<Picture> commodityPicList = new ArrayList<>();
            for (Integer picId : picIdList) {
                commodityPicList.add(pictureDao.selectById(picId));
            }
            commodity.setUrl(commodityPicList.get(0).getUrl());
        }
        return commodities;
    }

    public static List<Commodity> removeDuplicateWithOrder(List<Commodity> list) {

        List<Commodity> commodities = new ArrayList<>();
        for  ( int  i  =   0 ; i  <  list.size()  -   1 ; i ++ )  {
            for  ( int  j  =  list.size()  -   1 ; j  >  i; j -- )  {
                if  (list.get(j).getCommodityId()==list.get(i).getCommodityId())  {
                    list.remove(j);
                }
            }
        }
        if(list.size()>=3) {
            commodities.add(list.get(0));
            commodities.add(list.get(1));
            commodities.add(list.get(2));
        }else{
            commodities.addAll(list);
        }
        return commodities;
    }
}

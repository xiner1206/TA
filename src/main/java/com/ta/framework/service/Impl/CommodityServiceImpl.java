package com.ta.framework.service.Impl;

import com.ta.framework.dao.CommodityDao;
import com.ta.framework.dao.PictureDao;
import com.ta.framework.entity.Commodity;
import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Picture;
import com.ta.framework.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
}

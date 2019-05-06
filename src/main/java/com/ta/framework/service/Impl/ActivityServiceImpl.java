package com.ta.framework.service.Impl;

import com.ta.framework.dao.ActivityDao;
import com.ta.framework.dao.PictureDao;
import com.ta.framework.entity.Activity;
import com.ta.framework.entity.Commodity;
import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Picture;
import com.ta.framework.service.ActivityService;
import com.ta.framework.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private PictureDao pictureDao;

    @Autowired
    private CommodityService commodityService;


    @Override
    public Page<Activity> select(Page<Activity> page){
        assert page.getPageSize() > 0;
        if(page.getCondition() == null) {
            page.setCondition(new Activity());
        }
        if(page.getPageNum() == null || page.getPageNum() <= 0) {
            page.setPageNum(1);
        }
        page.setTotalRecord(countByPage(page));
        Page<Activity> pg = new Page<>(page.getPageNum(),page.getPageSize(),page.getTotalRecord());
        pg.setCondition(page.getCondition());
        List<Activity> activityList = activityDao.selectByPage(pg);
        for (Activity activity:activityList) {
            List<Integer> picIdList =activity.getActivityPicIdList();
            List<Picture> activityPicList = new ArrayList<>();
            for (Integer picId: picIdList) {
                activityPicList.add(pictureDao.selectById(picId));
            }
            activity.setActivityPicList(activityPicList);
        }
        pg.setList(activityList);
        return pg;
    }

    @Override
    public int countByPage(Page<Activity> page) {
        assert page.getPageSize() > 0;
        if(page.getCondition() == null) {
            page.setCondition(new Activity());
        }
        if(page.getPageNum() == null || page.getPageNum() <= 0) {
            page.setPageNum(1);
        }
        return activityDao.countByPage(page);
    }

    @Override
    public int addAndUpdateActivity(Activity activity) {
        Commodity commodity = new Commodity();
        List<Integer> commodityIdList = new ArrayList<>();
        commodityIdList.addAll(activity.getCommodityIdList());
        if(commodityIdList.size() !=0 ){
            for (Integer i:commodityIdList ){
                if(activity.getActivityDiscount() == 10){
                    commodity.setCommodityId(i);
                    commodity.setOtherAc(activity);
                }else{
                    commodity.setCommodityId(i);
                    commodity.setDiscountAc(activity);
                }
                commodityService.addAndUpdateCommodity(commodity);
            }
        }
        List<Integer> activityIdList = new ArrayList<>();
        activity.setActivityPicIdList(activityIdList);
        activityIdList.clear();
        activityIdList.addAll(getPicIdList(activity));
        if(activity.getActivityId() == null || activity.getActivityId() == 0)
            return activityDao.insert(activity);
        else
            return activityDao.update(activity);
    }

    public List<Integer> getPicIdList(Activity activity){
        List<Integer> listid = new ArrayList<>();
        for(Picture picture:activity.getActivityPicList()){
            listid.add(picture.getPictureId());
            pictureDao.update(picture);
        }
        return  listid;
    }
}

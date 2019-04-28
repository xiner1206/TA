package com.ta.framework.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Activity {
    private Integer activityId;
    private String activityName;
    private Integer activityState;
    private String activityRemark;
    private Integer activityDiscount;
    private Date createTime;
    private Date endTime;
    private List<Integer> activityPicIdList;
    private List<Picture> activityPicList;
    private Store store;
    private List<Integer> commodityIdList;

    public Activity() {
    }

    public Activity(String activityName, Integer activityState, String activityRemark, Integer activityDiscount, Date createTime, Date endTime, List<Integer> activityPicIdList, List<Picture> activityPicList, Store store) {
        this.activityName = activityName;
        this.activityState = activityState;
        this.activityRemark = activityRemark;
        this.activityDiscount = activityDiscount;
        this.createTime = createTime;
        this.endTime = endTime;
        this.activityPicIdList = activityPicIdList;
        this.activityPicList = activityPicList;
        this.store = store;
    }

    public List<Integer> getCommodityIdList() {
        return commodityIdList;
    }

    public void setCommodityIdList(List<Integer> commodityIdList) {
        this.commodityIdList = commodityIdList;
    }

    public List<Integer> getActivityPicIdList() {
        return activityPicIdList;
    }

    public void setActivityPicIdList(List<Integer> activityPicIdList) {
        this.activityPicIdList = activityPicIdList;
    }


    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getActivityState() {
        return activityState;
    }

    public void setActivityState(Integer activityState) {
        this.activityState = activityState;
    }

    public String getActivityRemark() {
        return activityRemark;
    }

    public void setActivityRemark(String activityRemark) {
        this.activityRemark = activityRemark;
    }

    public Integer getActivityDiscount() {
        return activityDiscount;
    }

    public void setActivityDiscount(Integer activityDiscount) {
        this.activityDiscount = activityDiscount;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getEndTime() {
        return endTime;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<Picture> getActivityPicList() {
        return activityPicList;
    }

    public void setActivityPicList(List<Picture> activityPicList) {
        this.activityPicList = activityPicList;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}


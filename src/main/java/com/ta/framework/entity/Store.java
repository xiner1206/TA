package com.ta.framework.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Store {

    private Integer storeId;
    private String storeName;
    private String storeType;
    private String storePhone;
    private String storeLocation;
    private String storeRemark;
    private Integer storeState;
    private Date createTime;
    private Date endTime;
    private List<Integer> storePicIdList;
    private List<Picture> storePicList;
    private User user;
    private Trade trade;
    private String url;
    private Integer tradeId;
    private Integer hotNum;
    private boolean betterStore;

    public Store() {
    }

    public Store(String storeName, String storeType, String storePhone, String storeLocation, String storeRemark, Integer storeState, Date createTime, Date endTime, List<Integer> storePicIdList, List<Picture> storePicList, User user, Trade trade) {
        this.storeName = storeName;
        this.storeType = storeType;
        this.storePhone = storePhone;
        this.storeLocation = storeLocation;
        this.storeRemark = storeRemark;
        this.storeState = storeState;
        this.createTime = createTime;
        this.endTime = endTime;
        this.storePicIdList = storePicIdList;
        this.storePicList = storePicList;
        this.user = user;
        this.trade = trade;
    }

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public String getStoreRemark() {
        return storeRemark;
    }

    public void setStoreRemark(String storeRemark) {
        this.storeRemark = storeRemark;
    }

    public Integer getStoreState() {
        return storeState;
    }

    public void setStoreState(Integer storeState) {
        this.storeState = storeState;
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

    public List<Integer> getStorePicIdList() {
        return storePicIdList;
    }

    public void setStorePicIdList(List<Integer> storePicIdList) {
        this.storePicIdList = storePicIdList;
    }

    public List<Picture> getStorePicList() {
        return storePicList;
    }

    public void setStorePicList(List<Picture> storePicList) {
        this.storePicList = storePicList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }

    public Integer getHotNum() {
        return hotNum;
    }

    public void setHotNum(Integer hotNum) {
        this.hotNum = hotNum;
    }

    public boolean isBetterStore() {
        return betterStore;
    }

    public void setBetterStore(boolean betterStore) {
        this.betterStore = betterStore;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", storeType='" + storeType + '\'' +
                ", storePhone='" + storePhone + '\'' +
                ", storeLocation='" + storeLocation + '\'' +
                ", storeRemark='" + storeRemark + '\'' +
                ", storeState=" + storeState +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                ", storePicIdList=" + storePicIdList +
                ", storePicList=" + storePicList +
                ", user=" + user +
                ", trade=" + trade +
                ", url='" + url + '\'' +
                ", tradeId=" + tradeId +
                ", hotNum=" + hotNum +
                ", betterStore=" + betterStore +
                '}';
    }
}

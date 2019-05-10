package com.ta.framework.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Trade {

    private Integer tradeId;
    private String tradeName;
    private String tradePhone;

    /**
     * 下架 0
     * 在线 1
     */
    private Integer tradeState;
    private Date createTime;
    private Date endTime;
    private String tradeRemark;
    private String tradeLocation;
    private List<Picture> tradePicList;
    private List<Integer> tradePicIdList;
    private User user;
    private String url;

    public Trade() {
    }

    public Trade(String tradeName, String tradePhone, Integer tradeState, Date createTime, Date endTime, String tradeRemark, String tradeLocation, List<Picture> tradePicList, List<Integer> tradePicIdList, User user) {
        this.tradeName = tradeName;
        this.tradePhone = tradePhone;
        this.tradeState = tradeState;
        this.createTime = createTime;
        this.endTime = endTime;
        this.tradeRemark = tradeRemark;
        this.tradeLocation = tradeLocation;
        this.tradePicList = tradePicList;
        this.tradePicIdList = tradePicIdList;
        this.user = user;

    }

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTradePhone() {
        return tradePhone;
    }

    public void setTradePhone(String tradePhone) {
        this.tradePhone = tradePhone;
    }

    public Integer getTradeState() {
        return tradeState;
    }

    public void setTradeState(Integer tradeState) {
        this.tradeState = tradeState;
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

    public String getTradeRemark() {
        return tradeRemark;
    }

    public void setTradeRemark(String tradeRemark) {
        this.tradeRemark = tradeRemark;
    }

    public String getTradeLocation() {
        return tradeLocation;
    }

    public void setTradeLocation(String tradeLocation) {
        this.tradeLocation = tradeLocation;
    }

    public List<Picture> getTradePicList() {
        return tradePicList;
    }

    public void setTradePicList(List<Picture> tradePicList) {
        this.tradePicList = tradePicList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public List<Integer> getTradePicIdList() {
        return tradePicIdList;
    }

    public void setTradePicIdList(List<Integer> tradePicIdList) {
        this.tradePicIdList = tradePicIdList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}


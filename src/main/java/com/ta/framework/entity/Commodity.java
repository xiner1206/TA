package com.ta.framework.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Commodity {

    private Integer commodityId;
    private String commodityName;
    private Integer commodityState;
    private BigDecimal commodityPrice;
    private String commodityRemark;
    private Date createTime;
    private Date endTime;
    private List<Picture> commodityPicList;
    private List<Integer> commodityPicIdList;
    private Store store;
    private Activity discountAc;
    private BigDecimal discountPrice;
    private Activity otherAc;
    private List<BigDecimal> priceInterval;
    private BigDecimal startPrice;
    private BigDecimal endPrice;
    private String url;
    private Integer storeId;
    private Integer hotNum;

    public Commodity() {
    }

    public Commodity(String commodityName, Integer commodityState, BigDecimal commodityPrice, String commodityRemark, Date createTime, Date endTime, List<Picture> commodityPicList, List<Integer> commodityPicIdList, Store store, Activity discountAc, BigDecimal discountPrice, Activity otherAc,List<BigDecimal> priceInterval) {
        this.commodityName = commodityName;
        this.commodityState = commodityState;
        this.commodityPrice = commodityPrice;
        this.commodityRemark = commodityRemark;
        this.createTime = createTime;
        this.endTime = endTime;
        this.commodityPicList = commodityPicList;
        this.commodityPicIdList = commodityPicIdList;
        this.store = store;
        this.discountAc = discountAc;
        this.discountPrice = discountPrice;
        this.otherAc = otherAc;
        this.priceInterval = priceInterval;
    }

    public Commodity(String commodityName, Integer commodityState, BigDecimal commodityPrice, String commodityRemark, Date createTime, Date endTime, List<Picture> commodityPicList, List<Integer> commodityPicIdList, Store store, Commodity discountAc, Commodity otherAc) {
        this.commodityName = commodityName;
        this.commodityState = commodityState;
        this.commodityPrice = commodityPrice;
        this.commodityRemark = commodityRemark;
        this.createTime = createTime;
        this.endTime = endTime;
        this.commodityPicList = commodityPicList;
        this.commodityPicIdList = commodityPicIdList;
        this.store = store;

    }


    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Integer getCommodityState() {
        return commodityState;
    }

    public void setCommodityState(Integer commodityState) {
        this.commodityState = commodityState;
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityRemark() {
        return commodityRemark;
    }

    public void setCommodityRemark(String commodityRemark) {
        this.commodityRemark = commodityRemark;
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

    public List<Picture> getCommodityPicList() {
        return commodityPicList;
    }

    public void setCommodityPicList(List<Picture> commodityPicList) {
        this.commodityPicList = commodityPicList;
    }

    public List<Integer> getCommodityPicIdList() {
        return commodityPicIdList;
    }

    public void setCommodityPicIdList(List<Integer> commodityPicIdList) {
        this.commodityPicIdList = commodityPicIdList;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Activity getDiscountAc() {
        return discountAc;
    }

    public void setDiscountAc(Activity discountAc) {
        this.discountAc = discountAc;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Activity getOtherAc() {
        return otherAc;
    }

    public void setOtherAc(Activity otherAc) {
        this.otherAc = otherAc;
    }

    public List<BigDecimal> getPriceInterval() {
        return priceInterval;
    }

    public void setPriceInterval(List<BigDecimal> priceInterval) {
        this.priceInterval = priceInterval;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public BigDecimal getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(BigDecimal endPrice) {
        this.endPrice = endPrice;
    }

    public Integer getHotNum() {
        return hotNum;
    }

    public void setHotNum(Integer hotNum) {
        this.hotNum = hotNum;
    }
}

package com.ta.framework.entity.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class tradeAc {
    private Integer acId;
    private Integer userId;
    private String acName;
    private String storeName;
    private Integer acState;
    private Date createTime;
    private Date endTime;
    private Integer acDiscount;

    public tradeAc() {
    }

    public tradeAc(Integer acId, Integer userId, String acName, String storeName, Integer acState, Date createTime, Date endTime, Integer acDiscount) {
        this.acId = acId;
        this.userId = userId;
        this.acName = acName;
        this.storeName = storeName;
        this.acState = acState;
        this.createTime = createTime;
        this.endTime = endTime;
        this.acDiscount = acDiscount;
    }

    public Integer getAcId() {
        return acId;
    }

    public void setAcId(Integer acId) {
        this.acId = acId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAcName() {
        return acName;
    }

    public void setAcName(String acName) {
        this.acName = acName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getAcState() {
        return acState;
    }

    public void setAcState(Integer acState) {
        this.acState = acState;
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

    public Integer getAcDiscount() {
        return acDiscount;
    }

    public void setAcDiscount(Integer acDiscount) {
        this.acDiscount = acDiscount;
    }
}

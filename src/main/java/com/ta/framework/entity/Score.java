package com.ta.framework.entity;

public class Score {

    private Integer scoreId;
    private Double environment; //环境
    private Double serve; //服务
    private Double substantial; //性价比
    private Double totalScore; //总分
    private Integer userNum; //参与点评人数
    private Store store;

    public Score(Double environment, Double serve, Double substantial, Double totalScore, Integer userNum, Store store) {
        this.environment = environment;
        this.serve = serve;
        this.substantial = substantial;
        this.totalScore = totalScore;
        this.userNum = userNum;
        this.store = store;
    }

    public Score() {
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Double getEnvironment() {
        return environment;
    }

    public void setEnvironment(Double environment) {
        this.environment = environment;
    }

    public Double getServe() {
        return serve;
    }

    public void setServe(Double serve) {
        this.serve = serve;
    }

    public Double getSubstantial() {
        return substantial;
    }

    public void setSubstantial(Double substantial) {
        this.substantial = substantial;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", environment=" + environment +
                ", serve=" + serve +
                ", substantial=" + substantial +
                ", totalScore=" + totalScore +
                ", userNum=" + userNum +
                ", store=" + store +
                '}';
    }
}

package com.ta.framework.entity;

public class Picture {

    private Integer pictureId;
    private String pictureWay;

    public Picture() {
    }

    public Picture(String pictureWay) {
        this.pictureWay = pictureWay;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }


    public String getPictureWay() {
        return pictureWay;
    }

    public void setPictureWay(String pictureWay) {
        this.pictureWay = pictureWay;
    }
}

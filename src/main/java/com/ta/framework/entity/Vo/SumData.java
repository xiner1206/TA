package com.ta.framework.entity.Vo;


public class SumData {

    private String name;
    private Integer sum;

    public SumData() {
    }

    public SumData(String name, Integer sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}

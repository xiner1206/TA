package com.ta.framework.entity.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;


public class Page<T> {

    private Integer pageNum; //当前页，从请求那边传过来
    private Integer pageSize; //每页显示条数
    private Integer totalRecord; //总条数

    private Integer totalPage; //总页数
    private Integer startIndex; //索引
    private T condition;
    private List<T> list;



    public Page() {
    }

    public Page(Integer pageNum, Integer pageSize, Integer totalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        //totalPage 总页数计算
        if (totalRecord % pageSize == 0) {
            this.totalPage = totalRecord / pageSize;
        } else {
            this.totalPage = totalRecord / pageSize + 1;
        }
        //开始索引
        this.startIndex = (pageNum - 1) * pageSize;
    }


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }


    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

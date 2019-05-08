package com.ta.framework.entity;

public class User {

    private Integer userId;
    private String userName;
    private String userNum;
    private String userPassword;
    private Integer userState;
    private Integer tosId;
    public User() {

    }

    public User(String userName, String userNum, String userPassword, Integer userState) {
        this.userName = userName;
        this.userNum = userNum;
        this.userPassword = userPassword;
        this.userState = userState;
    }

    public User(String userNum) {
        this.userNum = userNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Integer getTosId() {
        return tosId;
    }

    public void setTosId(Integer tosId) {
        this.tosId = tosId;
    }
}

package com.object;

import org.omg.PortableInterceptor.INACTIVE;

public class user {
    private Integer userId;
    private String userCount;
    private String userName;
    private String userPasswd;

    public user() {
    }

    public user(Integer userId, String userCount, String userName, String userPasswd) {
        this.userId = userId;
        this.userCount = userCount;
        this.userName = userName;
        this.userPasswd = userPasswd;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCount() {
        return userCount;
    }

    public void setUserCount(String userCount) {
        this.userCount = userCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    @Override
    public String toString() {
        return "user{" +
                "userId=" + userId +
                ", userCount='" + userCount + '\'' +
                ", userName='" + userName + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                '}';
    }
}

package com.example.tong.zzdxandroid.bean;

import java.io.Serializable;

/**
 * Created by tong- on 2017/4/30.
 */
public class Messenger implements Serializable{
    private int messengerId;
    private String messengerTitle;
    private String messengerPage;
    private int userId;
    private String userName;

    public int getMessengerId() {
        return messengerId;
    }

    public void setMessengerId(int messengerId) {
        this.messengerId = messengerId;
    }

    public String getMessengerTitle() {
        return messengerTitle;
    }

    public void setMessengerTitle(String messengerTitle) {
        this.messengerTitle = messengerTitle;
    }

    public String getMessengerPage() {
        return messengerPage;
    }

    public void setMessengerPage(String messengerPage) {
        this.messengerPage = messengerPage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

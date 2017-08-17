package com.example.tong.zzdxandroid.bean;

import java.io.Serializable;

/**
 * Created by tong- on 2017/4/30.
 */
public class Introduce implements Serializable{
    private int introduceId;
    private int typeId;
    private String typeName;
    private String typeColor;
    private String introducePage;
    private String introduceAddress;
    private String introduceGps;
    private String introduceName;

    public String getTypeColor() {
        return typeColor;
    }

    public void setTypeColor(String typeColor) {
        this.typeColor = typeColor;
    }

    public int getIntroduceId() {
        return introduceId;
    }

    public void setIntroduceId(int introduceId) {
        this.introduceId = introduceId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getIntroducePage() {
        return introducePage;
    }

    public void setIntroducePage(String introducePage) {
        this.introducePage = introducePage;
    }

    public String getIntroduceAddress() {
        return introduceAddress;
    }

    public void setIntroduceAddress(String introduceAddress) {
        this.introduceAddress = introduceAddress;
    }

    public String getIntroduceGps() {
        return introduceGps;
    }

    public void setIntroduceGps(String introduceGps) {
        this.introduceGps = introduceGps;
    }

    public String getIntroduceName() {
        return introduceName;
    }

    public void setIntroduceName(String introduceName) {
        this.introduceName = introduceName;
    }
}

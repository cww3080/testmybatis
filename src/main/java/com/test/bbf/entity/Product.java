package com.test.bbf.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 5611905043519315148L;
    private String proID;
    private String proName;
    private  String proType;
    private int proNum;

    public String getProID() {
        return proID;
    }
    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }
    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProType() {
        return proType;
    }
    public void setProType(String proType) {
        this.proType = proType;
    }

    public int getProNum() {
        return proNum;
    }
    public void setProNum(int proNum) {
        this.proNum = proNum;
    }

    @Override
    public String toString() {
        return "{" +
                "proID='" + proID + '\'' +
                ", proName='" + proName + '\'' +
                ", proType='" + proType + '\'' +
                ", proNum=" + proNum +
                '}';
    }
}
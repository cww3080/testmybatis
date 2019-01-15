package com.test.bbf.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private String proName;
    private  String proType;
    private int proNum;

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
}
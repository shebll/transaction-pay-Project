package com.SWE.ServiceApp.models;
import java.util.*;
public class Discount {
    int overallpercentage=0;
    Map<String,Integer> specificDiscount = new HashMap<String,Integer>();
    public void add(){}
    public void get(){}

    public Map<String, Integer> getSpecificDiscount() {
        return specificDiscount;
    }

    public void setSpecificDiscount(String n,int x) {
        this.specificDiscount.put(n,x);
    }

    public int getOverallpercentage() {
        return overallpercentage;
    }

    public void setOverallpercentage(int overallpercentage) {
        this.overallpercentage = overallpercentage;
    }
}

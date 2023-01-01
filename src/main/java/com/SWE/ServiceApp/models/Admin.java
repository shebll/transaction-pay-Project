package com.SWE.ServiceApp.models;
import com.SWE.ServiceApp.controllers.DiscountController;
import com.SWE.ServiceApp.bsl.OverallDiscountBsl;
import com.SWE.ServiceApp.bsl.SpecificDiscountBsl;
import com.SWE.ServiceApp.factory.FactoryService;

import java.util.HashMap;
import java.util.Map;

//import com.swe.*;
public class Admin {
    public String name;
    public String email;
    private double overall;

    public double getOverall() {
        return overall;
    }

    public void setOverall(double overall) {
        this.overall = overall;
    }

    public int pass;
    private Services sobj=new Services();
    Map<String,Integer> specificDiscount = new HashMap<String,Integer>();
    FactoryService createObj;

    public Map<String, Integer> getSpecificDiscount() {
        return specificDiscount;
    }

    public void setSpecificDiscount(Map<String, Integer> specificDiscount) {
        this.specificDiscount = specificDiscount;
    }

    DiscountController discountController;
    public Admin(){
    }
    public Admin(String name,String email,int pass){
        this.name=name;
        this.email=email;
        this.pass=pass;
        SpecificDiscountBsl specificDiscountBsl=new SpecificDiscountBsl();
        OverallDiscountBsl overallDiscountBsl=new OverallDiscountBsl();
        discountController=new DiscountController(specificDiscountBsl,overallDiscountBsl);

    }

    public Services getSobj() {
        return sobj;
    }

    public void setSobj(Services sobj) {
        this.sobj = sobj;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiscountController getDiscountController() {
        return discountController;
    }

    public void setDiscountController(DiscountController discountController) {
        this.discountController = discountController;
    }

}

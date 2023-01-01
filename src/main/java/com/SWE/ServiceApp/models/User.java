package com.SWE.ServiceApp.models;
import java.util.*;

public class User {
    public String name;
    public String email;
    public int pass;
    public int creditPass;
    public  double welletBalance ;
   // public PaymentController paymentController;
    public Vector<String>listOfPayment_name=new Vector<String>();
    public Vector<Double>listOfPayment_amount=new Vector<Double>();
    public Vector<String> adminResponseReq=new Vector<String>();
    public Vector<String> adminAnswer=new Vector<String>();
    double overall;
    double specific;



    public User() {
    }
    public void setBalance(double _b) {
        this.welletBalance+=_b ;
    }

    public User(String name,String email,int pass,int creditPass ) {
        this.name = name;
        this.email=email;
        this.creditPass=creditPass;
        this.pass=pass;

    }

    public double getSpecific() {
        return specific;
    }

    public void setSpecific(double specific) {
        this.specific = specific;
    }

    public double getOverall() {
        return overall;
    }

    public void setOverall(double overall) {
        this.overall = overall;
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

    public int getCreditPass() {
        return creditPass;
    }

    public void setCreditPass(int creditPass) {
        this.creditPass = creditPass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.SWE.ServiceApp.models;
import java.util.*;
public class Refunds {
    Scanner in = new Scanner(System.in);
    public Vector<User> listOfReq_obj=new Vector<User>();
    public Vector<String> listOfReq_name=new Vector<String>();
    public Vector<Double> listOfReq_amount=new Vector<Double>();

    public Refunds(){
        listOfReq_obj=new Vector<User>();
        listOfReq_name=new Vector<String>();
        listOfReq_amount=new Vector<Double>();
    }

    public Vector<Double> getListOfReq_amount() {
        return listOfReq_amount;
    }

    public void setListOfReq_amount(Vector<Double> listOfReq_amount) {
        this.listOfReq_amount = listOfReq_amount;
    }

    public Vector<String> getListOfReq_name() {
        return listOfReq_name;
    }

    public void setListOfReq_name(Vector<String> listOfReq_name) {
        this.listOfReq_name = listOfReq_name;
    }

    public Vector<User> getListOfReq_obj() {
        return listOfReq_obj;
    }

    public void setListOfReq_obj(Vector<User> listOfReq_obj) {
        this.listOfReq_obj = listOfReq_obj;
    }
}

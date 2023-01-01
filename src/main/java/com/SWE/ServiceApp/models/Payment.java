package com.SWE.ServiceApp.models;

public class Payment {
    public Services obj=new Services();
    public User userObj ;
    public int creditPass=0;
    public double wallet_balance=0;
    public Payment(User _userObj){
        this.userObj=_userObj;
        this.creditPass=_userObj.creditPass ;
        this.wallet_balance =_userObj.welletBalance ;
    }
    //public void pay(Vector<Admin>admins){}
    public void setpass(int _p){}
    public void Adding_fundsToTheWallet(){}
    public void  getBalance(){}
    public void setBalance(double _b) {}

}

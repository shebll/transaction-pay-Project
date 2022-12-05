package payment;

import java.util.*;

import account.Admin;
import account.User;
import services.Services;

public abstract class payment {
	public Services obj=new Services();
	public User userObj=new User();
	public int creditPass;
	public double wallet_balance=0;
	public payment(User _userObj,Services _obj){
		userObj=_userObj;
		obj=_obj;
	}
	public void pay(Vector<Admin>admins){}
	public void setpass(int _p){}
	public void Adding_fundsToTheWallet(){}
	public void  getBalance(){}
	public void setBalance(double _b) {
		// TODO Auto-generated method stub
	}

}

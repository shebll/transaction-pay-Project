package account;
import java.util.*;
import java.util.Map.Entry;

import payment.CreditCard;
import payment.DigitalWallet;
import payment.payment;
import services.Services;

public class User extends account  {
	Scanner in = new Scanner(System.in);
	private Services obj=null;

	public payment pay1=null;
	public payment pay2=null;
	public int creditPass;
	public Vector<String>listOfPayment_name=new Vector<String>();
	public Vector<Double>listOfPayment_amount=new Vector<Double>();
	public Vector<String> adminResponseReq=new Vector<String>();
	public Vector<String> adminAnswer=new Vector<String>();
	public User(){
	}	
	public User(String _n,String _e,int _p,int _c,Services _obj){
		this.name=_n;
		this.email=_e;
		this.pass=_p;
		this.creditPass=_c;
		obj=_obj;
		pay1=new CreditCard(this,_obj);
		pay2=new DigitalWallet(this,_obj);
	}
	
	public void search(){
		   String Sname;
		   System.out.println("please enter servies's name:");
		   Sname=in.next();
		   obj.searchSrevices(Sname);
	}
	public void  getComplteTransaction(){
		System.out.println("complete transaction"+"\n");
		for(int i=0;i<listOfPayment_amount.size();i++){
			System.out.println((i+1)+": "+listOfPayment_name.get(i)+" --> "+listOfPayment_amount.get(i)+"$"); 
		} 
		System.out.println();
		
	}

	
	
	
	
	
	
}

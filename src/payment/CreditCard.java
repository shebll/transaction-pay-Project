package payment;
import java.util.*;
import java.util.Map.Entry;

import account.Admin;
import account.User;
import services.Services;

public class CreditCard extends payment {
	Scanner in = new Scanner(System.in);
	public CreditCard(User _userObj,Services _obj) {
		super(_userObj, _obj);
	}
  
    public void setpass(int _p){
    	creditPass=_p;
    }
	public void pay(Vector<Admin>admins){
		double mxOverall=0;
		double mxSpecific=0;
		String name;
		int i=1;
		System.out.println("\n"+"please enter service's name:");
		for (Entry<String, Vector<String>> e : obj.getMp().entrySet()){
			System.out.println(i+":"+e.getKey());
			i++;
		}
		name=in.next();
		 System.out.println("\n"+"please enter name of the payment method:");
		 for(int j=0;j<obj.getMp().get(name).size();j++){
			 System.out.println((j+1)+":"+obj.getMp().get(name).get(j));
		 }
		 String s;
		 s=in.next();
		 double amount;
		   System.out.println("please enter cost.");
		   amount=in.nextInt();
		   int flag;
		   System.out.println("1:check discount.");
		   System.out.println("2:No thanks.");
		   System.out.println("choose: ");
		   flag=in.nextInt();
		   if(flag==1){
			   for(int j=0;j<admins.size();j++){
				   if(admins.get(j).overall.overallpercentage>mxOverall){
					   mxOverall=admins.get(j).overall.overallpercentage;
				   }
				   if(admins.get(j).specific.specificDiscount.get(name)!=null){
					     if(admins.get(j).specific.specificDiscount.get(name)>mxSpecific){
						   mxSpecific=admins.get(j).specific.specificDiscount.get(name);
					   }
				   }
			   }
			   int val;
			   System.out.println("1:Overall discount: "+mxOverall+"%.");
			   System.out.println("2:Specific discount: "+mxSpecific+"%.");
			   System.out.println("3:don't need discount.");
			   System.out.println("choose: ");
			   val=in.nextInt();
			   if(val==1){
				   amount-=(mxOverall/100)*amount;
			   }
			   else if(val==2){
				   amount-=(mxSpecific/100)*amount;
			   }   
		   }
		int num;
		System.out.println("please enter credit passcode:");
		num=in.nextInt();
		if(num!=creditPass){
			System.out.println("Error! wrong password.");
			return;
			}  
		 userObj.listOfPayment_name.add(s);
		 userObj.listOfPayment_amount.add(amount);
		 System.out.println("Transfer successfully");
	}
	
	public void Adding_fundsToTheWallet(){
		int num;
		System.out.println("please enter credit passcode:");
		num=in.nextInt(); 
		if(num!=creditPass){
			System.out.println("Error! wrong password.");
		}
		else{
			int amount;
			System.out.println("please enter the amount to store in digital wallet:");
			amount=in.nextInt();
			System.out.println("successful operation.");
			userObj.pay2.setBalance(amount);
		}
		 
	}
	
	
	
}

package payment;
import java.util.*;
import java.util.Map.Entry;

import account.Admin;
import account.User;
import services.Services;

public class DigitalWallet extends payment {
	Scanner in = new Scanner(System.in);
	public DigitalWallet(User _userObj,Services _obj) {
		super(_userObj, _obj);
	}
	public void setBalance(double _b){
		wallet_balance+=_b;
	}
	public void pay(Vector<Admin>admins){
		double mxOverall=0;
		double mxSpecific=0;
		String name;
		System.out.println("\n"+"please enter service's name:");
		for (Entry<String, Vector<String>> e : obj.getMp().entrySet()){
			System.out.println("-"+e.getKey());
		}
		name=in.next();
		 System.out.println("\n"+"please enter name of the payment method:");
		 for(int j=0;j<obj.getMp().get(name).size();j++){
			 System.out.println("-"+obj.getMp().get(name).get(j));
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
		   
		  if(amount>wallet_balance){
				System.out.println("Error! Your wallet does not have the required amount.");
				return;
			}
			else{
				wallet_balance-=amount;
			}
			 userObj.listOfPayment_name.add(s);
			 userObj.listOfPayment_amount.add(amount);
			 System.out.println("Transfer successfully");
		
	}
	public void  getBalance(){
		System.out.println("\n"+userObj.name+"'s balance: "+wallet_balance+"\n");
	}
}

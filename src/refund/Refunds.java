package refund;
import java.util.*;

import account.Admin;
import account.User; 
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
	public void sendReq(User _obj,String name,double amount){
		listOfReq_obj.add(_obj);
		listOfReq_name.add(name);
		listOfReq_amount.add(amount);
	}
	public void get(){ 
		System.out.println("Refunds list");
		for(int i=0;i<listOfReq_obj.size();i++){
			System.out.println((i+1)+": "+listOfReq_obj.get(i).name+" --> "+listOfReq_name.get(i)+" --> "+listOfReq_amount.get(i));
		}
	}
	public void checkReq(Admin _obj){
		int op;
		get();
		System.out.println("Choose request number:");
		op=in.nextInt();
		int op1=0;
		System.out.println("1:Accept this request.");
		System.out.println("2:Reject this request.");
		op1=in.nextInt();
		if(op1==1){
			listOfReq_obj.get(op-1).adminResponseReq.add("Admin "+_obj.name+" response: "+listOfReq_name.get(op-1));
			listOfReq_obj.get(op-1).adminAnswer.add("Accepted");
			listOfReq_obj.get(op-1).pay2.setBalance(listOfReq_amount.get(op-1));
			
		}
		else{
			listOfReq_obj.get(op-1).adminResponseReq.add("Admin "+_obj.name+" response: "+listOfReq_name.get(op-1));
			listOfReq_obj.get(op-1).adminAnswer.add("Rejected");
		}
		
	}
	
	 
	
	
	
	

	
}

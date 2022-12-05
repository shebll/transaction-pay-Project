package SF;
import java.util.*;
import java.util.Map.Entry;

import account.Admin;
import account.User;
import refund.Refunds;
import services.Services;
  
 
public class Main{
	private static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		Services Sobj=new Services();
		Vector<User>users=new Vector<User>();
		Vector<Admin>admins=new Vector<Admin>();
		Refunds refunds=new Refunds();
		
		boolean flag=true;
		while(flag){
		   int op;
		   System.out.println("1:sign up user.");
		   System.out.println("2:login user.");
		   System.out.println("3:sign up admin.");
		   System.out.println("4:login admin.");
		   System.out.println("5:Exit.");
		   op=in.nextInt();
		   
		   if(op==1){
			   String name,email;
			   int pass,Cpass;
			   while(true){
			   System.out.println("please enter your name:");
			   name=in.next();
			   boolean flag1=false;
			   for(int i=0;i<users.size();i++){
				   if(users.get(i).name.equals(name)){
					   flag1=true;
				   }
			   }
			   if(flag1==false){
				   break;
			   }
			   else{
				   System.out.println("Error! This name is already reserved.");
			   }
			   }
			   
			   while(true){
			   System.out.println("please enter your email:");
			   email=in.next();
			   boolean flag1=false;
			   for(int i=0;i<users.size();i++){
				   if(users.get(i).email.equals(email)){
					   flag1=true;
				   }
			   }
			   if(flag1==false){
				   break;
			   }
			   else{
				   System.out.println("Error! This email is already reserved.");
			   }
			   }
			   System.out.println("please enter your password:");
			   pass=in.nextInt(); 
			   System.out.println("please enter your credit card passcode:");
			   Cpass=in.nextInt(); 
			   User add=new User(name,email,pass,Cpass,Sobj);
			   users.add(add);
		   }
		   
		   else if(op==2){
			   String email;
			   int pass;
			   System.out.println("please enter your email:");
			   email=in.next();
			   System.out.println("please enter your password");
			   pass=in.nextInt();  
			   
			   boolean flag1=false;
			   User obj=new User();
			   for(int i=0;i<users.size();i++){
				   if(users.get(i).email.equals(email) && users.get(i).pass==pass){
					   obj=users.get(i);
					   flag1=true;
					   break;
				   }
			   }
			   if(flag1){
				   System.out.println("Hello Mr."+obj.name+".");
				   while(true){
				   int op1;
				   System.out.println("1:Search for services.");
				   System.out.println("2:pay for any service in the system.");
				   System.out.println("3:Adding funds to the wallet.");
				   System.out.println("4:send refund.");
				   System.out.println("5:view admin response.");
				   System.out.println("6:get my complete transaction.");
				   System.out.println("7:get my wallet balance.");
				   System.out.println("8:Exit");
				   op1=in.nextInt();
				   if(op1==1){
					   obj.search();
				   }
				   else if(op1==2){
					   int op2;
						System.out.println("you will pay via credit card or digtal wallet?");
						System.out.println("1:credit card.");
						System.out.println("2:digital wallet.");
						op2=in.nextInt();
						if(op2==1){
							obj.pay1.setpass(obj.creditPass);
							obj.pay1.pay(admins);
						}
						else {
							 obj.pay2.pay(admins);
						}
						 
				   }
				   else if(op1==3){
						obj.pay1.setpass(obj.creditPass);
						obj.pay1.Adding_fundsToTheWallet();
				   }
				   else if(op1==4){
					   obj.getComplteTransaction();
					   System.out.println("please enter complete transaction number:");
					   int idx;
					   idx=in.nextInt();
					   String s=null;
					   refunds.sendReq(obj, obj.listOfPayment_name.get(idx-1),obj.listOfPayment_amount.get(idx-1));
				   }
				   else if(op1==5){
					   for(int i=0;i<obj.adminResponseReq.size();i++){
						   System.out.println(obj.adminResponseReq.get(i)+" --> "+obj.adminAnswer.get(i));
					   }
				   }
				   else if(op1==6){
					   obj.getComplteTransaction();
				   }
				   else if(op1==7){
					   obj.pay2.getBalance();
				   }
				   else {
					   break;
				   }
				   }
			   }
			   else{
				   System.out.println("this account not found.");
			   }
		   }
		   
		   else if(op==3){
			   String name,email;
			   int pass;
			   while(true){
			   System.out.println("please enter your name:");
			   name=in.next();
			   boolean flag1=false;
			   for(int i=0;i<admins.size();i++){
				   if(admins.get(i).name.equals(name)){
					   flag1=true;
				   }
			   }
			   if(flag1==false){
				   break;
			   }
			   else{
				   System.out.println("Error! This name is already reserved.");
			   }
			   }
			   
			   while(true){
			   System.out.println("please enter your email:");
			   email=in.next();
			   boolean flag1=false;
			   for(int i=0;i<admins.size();i++){
				   if(admins.get(i).email.equals(email)){
					   flag1=true;
				   }
			   }
			   if(flag1==false){
				   break;
			   }
			   else{
				   System.out.println("Error! This email is already reserved.");
			   }
			   }
			   System.out.println("please enter your password");
			   pass=in.nextInt();   
			   
			   Admin add=new Admin(name,email,pass,Sobj);
			   admins.add(add);
		   }
		   
		   
		   else if(op==4){
			   String email;
			   int pass;
			   System.out.println("please enter your email:");
			   email=in.next();
			   System.out.println("please enter your password");
			   pass=in.nextInt();  
			   
			   boolean flag1=false;
			   Admin obj=new Admin();
			   for(int i=0;i<admins.size();i++){
				   if(admins.get(i).email.equals(email) && admins.get(i).pass==pass){
					   obj=admins.get(i);
					   flag1=true;
					   break;
				   }
			   }
			   if(flag1){
				   System.out.println("Hello Admin --> "+obj.name+".");
				   while(true){
					   System.out.println("Choose operation number you want to perform. ");
				   int op2;
				   System.out.println("1:Display user list.");
				   System.out.println("2:Add new services.");
				   System.out.println("3:Add discount.");
				   System.out.println("4:Check user's refunds.");
				   System.out.println("5:Exit.");
				   
				   op2=in.nextInt();
				   if(op2==1){
					   System.out.println("list of users.");
					   for(int i=0;i<users.size();i++){
						   System.out.println("name: "+users.get(i).name); 
						   System.out.println("email: "+users.get(i).email); 
						   System.out.println("passwrd: "+users.get(i).pass);
						   System.out.println("------------------"); 
					   }
				   }
				   else if(op2==2){
					   obj.getCreateObj().createService();
				   }
				   else if(op2==3){
					   int o;
					   System.out.println("1:Add overall discount"); 
					   System.out.println("2:Add specific discount"); 
					   o=in.nextInt();
					   if(o==1){
						   obj.overall.add();
					   }
					   else{
						   obj.specific.add();
					   }
				   }
				   else if(op2==4){
					   refunds.checkReq(obj);
				   }
				   else {
					   break;
				   }
				   }
		       }
		       else{
				   System.out.println("this account not found.");
			   }
		   }
		   else{
			   
			   flag=false;
		   }	
		}
		
	}
}




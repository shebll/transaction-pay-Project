package discounts;

import java.util.Scanner;

import observer.Observer;
import payment.payment;

public class SpecificDiscount extends Discount {
	Scanner in = new Scanner(System.in);
	public void add(){
	 String val;
   	 System.out.println("Please enter service's name you want to add specfic discount :");
   	 val=in.next();
   	 int val1;
   	 System.out.println("Please enter discount percentage:");
	 val1=in.nextInt();
	 specificDiscount.put(val, val1);	
	}
	public void get(){ 
		System.out.println(specificDiscount);
	}
	public SpecificDiscount() {}
	public SpecificDiscount(payment p) {
		super(p);
		super.setName("overall Discount");
		// TODO Auto-generated constructor stub
	}	
 	@Override
 	public void subscribe(Observer o) {
 		observerlist.add(o);
 		
 	}

 	@Override
 	public void unSubscribe(Observer o) {
 		// TODO Auto-generated method stub
 		observerlist.remove(o);
 	}

 	@Override
 	public void notifyAllSubscribe() {
 		// TODO Auto-generated method stub
 		for ( Observer o : observerlist) {
 			o.update(availability);
 		}
}
}

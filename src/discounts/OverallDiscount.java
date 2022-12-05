package discounts;

import java.util.Scanner;

import observer.Observer;
import payment.payment;

public class OverallDiscount extends Discount {
	Scanner in = new Scanner(System.in);
     public void add(){
    	 int val;
    	 System.out.println("Please enter discount percentage(10% -> 100%):");
    	 val=in.nextInt();
    	 overallpercentage=val;
     }
     public void get(){
 		System.out.println(overallpercentage); 
 	}
    public OverallDiscount() {};
 	public OverallDiscount(payment p) {
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

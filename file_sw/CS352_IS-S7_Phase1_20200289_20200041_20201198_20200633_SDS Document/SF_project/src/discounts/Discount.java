package discounts;
import java.util.*;

import observer.Subject;
import observer.Observer;
import payment.payment;
public abstract class Discount implements Subject{
	private payment p;
	private String  name ;
	protected String  availability ;
	protected List<Observer> observerlist ;
	public int overallpercentage=0;
	public Map<String,Integer> specificDiscount = new HashMap<String,Integer>();
	public void add(){}
	public void get(){}
	public   void setAvailability(boolean x) {
		this.availability= this.name + ( x ? " available" : " not available");
		notifyAllSubscribe();
	};
	protected   void setName(String x) {
		this.name=x;
	};
	public abstract void subscribe(Observer o) ;
	public abstract void unSubscribe(Observer o);

	public abstract  void notifyAllSubscribe();
	public Discount() {};
	public Discount(payment p) {
		this.p =p;
		observerlist =new ArrayList<Observer>() ;
	}

}

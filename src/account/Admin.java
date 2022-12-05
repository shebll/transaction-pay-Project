package account;

import discounts.Discount;
import discounts.OverallDiscount;
import discounts.SpecificDiscount;
import services.FactoryService;
import services.Services;

public class Admin extends account {
	private Services sobj=null;
	private FactoryService createObj;
	public Discount overall=null;
	public Discount specific=null;
	public Admin(){
	}	
	public Admin(String _n,String _e,int _p,Services _obj){
		this.name=_n;
		this.email=_e;
		this.pass=_p;
		overall=new OverallDiscount();
		specific=new SpecificDiscount();	
		sobj=_obj;
		setCreateObj(new FactoryService(sobj));
	}
	public FactoryService getCreateObj() {
		return createObj;
	}
	public void setCreateObj(FactoryService createObj) {
		this.createObj = createObj;
	}
}

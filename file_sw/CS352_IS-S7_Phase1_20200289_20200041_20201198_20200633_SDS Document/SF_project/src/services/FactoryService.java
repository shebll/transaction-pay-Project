package services;
import java.util.*;
public class FactoryService {
	Scanner in = new Scanner(System.in);
	Services obj=null;
	public FactoryService(){}
	public FactoryService(Services _obj){
		obj=_obj;
	}
	public void createService(){
		Vector<String>vec=new Vector<String>();
		String name;
		System.out.println("plaese enter name of service you want to add:");
		name=in.next();
		String method;
		System.out.println("plaese enter the method type:");
		method=in.next();
		vec.add(method);
		obj.getMp().put(name,vec);
		
	}
	
}

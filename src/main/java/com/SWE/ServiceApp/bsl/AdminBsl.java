package com.SWE.ServiceApp.bsl;

import com.SWE.ServiceApp.models.Admin;

import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Service;

@Service
public class AdminBsl {
    private final Vector<Admin> adimnTable  =new Vector<>();

    public AdminBsl( ) {

    }

    public String add(Admin admin) {
        for(Admin x:adimnTable){
            if(x.getName().equals(admin.getName())){
                return "This name already exists.";
            }
        }
        adimnTable.add(admin);
        return "Add successful.";


    }

    public Admin getAdmin(String name,int pass) {
        for(Admin x:adimnTable){
            if(x.getName().equals(name)&&x.getPass()==pass){
                return x;
            }
        }
        return null;
    }
    public String createService( String name, int pass ,  String serviceName,String provider){
        Vector<String> vec=new Vector<String>();
        Admin currentAdmin = getAdmin(name,pass) ;
        if (currentAdmin==null){
            return  "this name not found or password wrong" ;
        }
        String names=serviceName;
        String method=provider;
        vec.add(method);
        currentAdmin.getSobj().getMp().put(names,vec);
        return "Done.";
    }
    public String searchSrevices(  String name, int pass ,String nameS){
        Admin currentAdmin = getAdmin(name,pass) ;
        if (currentAdmin==null){
            return  "this name not found or password wrong" ;
        }
        if(currentAdmin.getSobj().getMp().get(nameS) != null){
            return (nameS+"\n"+currentAdmin.getSobj().getMp().get(nameS)+"\n\n");
        }
        else {
            return ("this services not fount."+"\n");
        }
    }
    public String  addSpecificDiscount( String name, int pass,String nameS,int val){
        Admin currentAdmin = getAdmin(name,pass) ;
        if (currentAdmin==null){
            return  "this name not found or password wrong" ;
        }
        currentAdmin.getSpecificDiscount().put(nameS, val);
        return  "Done." ;
    }
    public String  addOverallDiscount( String name, int pass,int val){
        Admin currentAdmin = getAdmin(name,pass) ;
        if (currentAdmin==null){
            return  "this name not found or password wrong" ;
        }
        currentAdmin.setOverall(val);
        return  "Done." ;
    }
    public Map<String, Integer> getlist( String name,int pass){
        Admin currentAdmin = getAdmin(name,pass) ;
        if (currentAdmin==null){
            return  null ;
        }
        return currentAdmin.getSpecificDiscount();

    }
    public double getOverall() {
        double mxOverall = 0;
        for (int j = 0; j < adimnTable.size(); j++) {
            if (adimnTable.get(j).getOverall() > mxOverall) {
                mxOverall = adimnTable.get(j).getOverall();
            }
        }
            return mxOverall;

    }
    public double getSpecific(String name) {
        double mxSpecific=0;
        for(int j=0;j<adimnTable.size();j++){
            if(adimnTable.get(j).getSpecificDiscount().get(name)!=null){
                if(adimnTable.get(j).getSpecificDiscount() .get(name)>mxSpecific){
                    mxSpecific=adimnTable.get(j).getSpecificDiscount().get(name);
                }
            }
        }
        return mxSpecific;

    }
    public String checkDiscount(String name){
        double mxOverall=0;
        double mxSpecific=0;
        for(int j=0;j<adimnTable.size();j++){
            if(adimnTable.get(j).getOverall()>mxOverall){
                mxOverall=adimnTable.get(j).getOverall();
            }
            if(adimnTable.get(j).getSpecificDiscount().get(name)!=null){
                if(adimnTable.get(j).getSpecificDiscount() .get(name)>mxSpecific){
                    mxSpecific=adimnTable.get(j).getSpecificDiscount().get(name);
                }
            }
        }
        return "1:Overall discount: "+mxOverall+"%. \n"+"2:Specific discount: "+mxSpecific+"%.";
    }


}

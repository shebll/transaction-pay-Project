package com.SWE.ServiceApp.bsl;

import com.SWE.ServiceApp.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Service

public class UserBsl {
    private final List<User> userTable ;

    public UserBsl() {
         userTable=new ArrayList<>();
    }



    //////////// sign up functionality ///////////////
    public String signUp(User user) {
        for(User x:userTable){
            if(x.getName().equals(user.getName())){
                return "This name already exists use another name.";
            }
        }
        userTable.add(user);
        return "sign Up successful.";


    }
    //////////// sign in /login functionality ///////////////
    public User logIn(String name,int pass) {
        for(User x:userTable){
            if(x.getName().equals(name) &&x.getPass()==pass){
                return x;
            }
        }
        return null;
    }
    //////////// sign in /login functionality ///////////////
    public String  getComplteTransaction(String name,int pass){
        User currentUser = logIn(name,pass) ;
        if (currentUser==null){
            return "this name not found or password wrong" ;
        }
            return (currentUser.listOfPayment_name + "\n"+currentUser.listOfPayment_amount) ;
    }
    public String getResponse( String name, int pass  ){
        User currentUser = logIn(name,pass) ;
        if (currentUser==null){
            return "this name not found or password wrong" ;
        }
        Vector<String> x =new Vector<>();
        for (int i = 0; i < currentUser.adminResponseReq.size(); i++) {
            x.add((i + 1) + ": " + currentUser.adminResponseReq.get(i)+ " --> " + currentUser.adminAnswer.get(i) + " --> " + currentUser.listOfPayment_amount.get(i) +"\n");
        }
        return x  +" \n" +" end";
    }
    public double getBalance( String name, int pass  ){
        User currentUser = logIn(name,pass) ;
        if (currentUser==null){
            return 0 ;
        }
        return currentUser.welletBalance ;
    }
    public void setOverallAndSpecific( String name ,int pass,double overall, double specific  ){
        User currentUser = logIn(name,pass) ;
        if (currentUser==null){
            return ;
        }
        currentUser.setOverall(overall);
        currentUser.setSpecific(specific);
    }

}

package com.SWE.ServiceApp.bsl;
import java.util.*;

import com.SWE.ServiceApp.models.Admin;
import com.SWE.ServiceApp.models.Refunds;
import com.SWE.ServiceApp.models.User;
import org.springframework.stereotype.Service;

@Service
public class RefundsBsl {
    Scanner in = new Scanner(System.in);
    Refunds refunds;

    public RefundsBsl() {
        refunds = new Refunds();
    }

    public String sendReq(User _obj, String name, double amount) {

        refunds.listOfReq_obj.add(_obj);
        refunds.listOfReq_name.add(name);
        refunds.listOfReq_amount.add(amount);
        return "done" ;
    }

    public String get() {
        Vector<String>  x =new Vector<>();
        for (int i = 0; i < refunds.listOfReq_obj.size(); i++) {
            x.add((i + 1) + ": " + refunds.listOfReq_obj.get(i).name + " --> " + refunds.listOfReq_name.get(i) + " --> " + refunds.listOfReq_amount.get(i) +"\n");
        }
        return x  +" \n" +" end";
    }

    public String checkReq(Admin _obj, int id , String statue) {

        if (statue.equals("ok")||statue.equals("OK")||statue.equals("Ok")) {
            refunds.listOfReq_obj.get(id - 1).adminResponseReq.add("Admin " + _obj.name + " response: " + refunds.listOfReq_name.get(id - 1));
            refunds.listOfReq_obj.get(id - 1).adminAnswer.add("Accepted");
            refunds.listOfReq_obj.get(id - 1).listOfPayment_amount.add(refunds.listOfReq_amount.get(id-1));
            refunds.listOfReq_obj.get(id - 1).setBalance(refunds.listOfReq_amount.get(id-1));
            return " accepted   "  ;
        } else {
            refunds.listOfReq_obj.get(id - 1).adminResponseReq.add("Admin " + _obj.name + " response: " + refunds.listOfReq_name.get(id - 1));
            refunds.listOfReq_obj.get(id - 1).adminAnswer.add("Rejected");
            return " rejected   "   ;
        }

    }
}

package com.SWE.ServiceApp.bsl;

import com.SWE.ServiceApp.models.Payment;
import com.SWE.ServiceApp.models.User;
import org.springframework.stereotype.Service;
@Service
public class PaymentCreditCardBsl  {
    Payment payment;
    public PaymentCreditCardBsl() {

    }


    public String pay(User user, String serviceName , String provider , double amount , int pass ){

        payment =new Payment(user) ;
        String s = serviceName + "/Provider:" + provider;
        payment.userObj.listOfPayment_name.add(s);
        payment.userObj.listOfPayment_amount.add(amount);

        return "Transfer successfully";

    }

    public String Adding_fundsToTheWallet(User user,int pass ,double amount ){
        payment =new Payment(user) ;
        {
            setBalance(amount);
            user.setBalance(amount);
            return("successful operation.");
        }
    }
    public void setpass(int _p){
        payment.creditPass=_p;
    }
    public void setBalance(double _b){
        payment.wallet_balance+=_b;

    }
}

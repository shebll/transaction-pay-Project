package com.SWE.ServiceApp.bsl;

import com.SWE.ServiceApp.models.User;
import com.SWE.ServiceApp.models.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentDigitalWalletBsl {
    Payment payment;
    public PaymentDigitalWalletBsl() {
    }


    public String pay(User user, String serviceName , String provider , double amount ){

        payment =new Payment(user) ;

        if(amount>user.welletBalance){
            return "error amount is bigger than your balance!";
        }else {
            user.welletBalance -= amount;
            payment.wallet_balance-=amount ;
            String ss = payment.wallet_balance+"";
            String x= user.welletBalance +"";
            String s = serviceName + "/Provider:" + provider;
            payment.userObj.listOfPayment_name.add(s);
            payment.userObj.listOfPayment_amount.add(amount);

            return "Transfer successfully.";
        }


    }

    public void  getBalance(){
        System.out.println("\n"+payment.userObj.name+"'s balance: "+payment.wallet_balance+"\n");
    }
    public void setBalance(double _b){
        payment.wallet_balance+=_b;
    }


}

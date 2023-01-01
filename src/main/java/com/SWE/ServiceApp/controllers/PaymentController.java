package com.SWE.ServiceApp.controllers;
import com.SWE.ServiceApp.bsl.PaymentCreditCardBsl;
import com.SWE.ServiceApp.bsl.PaymentDigitalWalletBsl;
import com.SWE.ServiceApp.bsl.UserBsl;
import com.SWE.ServiceApp.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    PaymentDigitalWalletBsl paymentDigitalWalletBsl;
    PaymentCreditCardBsl paymentCreditCardBsl;
    UserBsl userBsl ;

    public PaymentController(PaymentDigitalWalletBsl dBsl ,PaymentCreditCardBsl wBsl ,UserBsl bsl) {
        this.paymentDigitalWalletBsl = dBsl ;
        this.paymentCreditCardBsl = wBsl ;
        this.userBsl =bsl;
    }

    public PaymentDigitalWalletBsl getPaymentDigitalWalletBsl() {
        return paymentDigitalWalletBsl;
    }

    public void setPaymentDigitalWalletBsl(PaymentDigitalWalletBsl paymentDigitalWalletBsl) {
        this.paymentDigitalWalletBsl = paymentDigitalWalletBsl;
    }

    public PaymentCreditCardBsl getPaymentCreditCardBsl() {
        return paymentCreditCardBsl;
    }

    public void setPaymentCreditCardBsl(PaymentCreditCardBsl paymentCreditCardBsl) {
        this.paymentCreditCardBsl = paymentCreditCardBsl;
    }
    ///////////////////// (URL) pay functionality ////////////////
    @PostMapping(value = "/pay/{serviceName}/{name}/{pass}/{paymethod}/{provider}/{amount}/{Discountstate}")
    public String pay(@PathVariable("serviceName")  String serviceName ,
                      @PathVariable("name")  String name ,
                      @PathVariable("pass")  int pass ,
                      @PathVariable("paymethod")  String paymethod ,
                      @PathVariable("provider")  String provider,
                      @PathVariable("amount")   double amount,
                      @PathVariable("Discountstate")   int Discountstate){
        User currentUser= userBsl.logIn(name,pass);
        if (currentUser==null){
            return "this name not found or password wrong" ;
        }
        if(Discountstate==1.0){
            amount-=(currentUser.getOverall()/100)*amount;
        }
        else{
            amount-=(currentUser.getSpecific()/100)*amount;
        }
        if(paymethod.equals("Credit")){
            return paymentCreditCardBsl.pay(currentUser,serviceName,provider,amount,pass);
        }else{
            return currentUser.getOverall()+" "+paymentDigitalWalletBsl.pay(currentUser,serviceName,provider,amount);
        }

    }
    ///////////////////// (URL) add Fund functionality ////////////////
    @GetMapping(value = "/addFund/{name}/{pass}/{amount}")
    public String Adding_fundsToTheWallet(@PathVariable String name , @PathVariable int pass ,@PathVariable double amount ){
        User currentUser =userBsl.logIn(name,pass) ;
        if (currentUser==null){
            return "this name not found or password wrong" ;
        }
        return  paymentCreditCardBsl.Adding_fundsToTheWallet(currentUser,pass,amount);

    }
}
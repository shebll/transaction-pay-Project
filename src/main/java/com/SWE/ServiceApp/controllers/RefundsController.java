package com.SWE.ServiceApp.controllers;
import com.SWE.ServiceApp.bsl.AdminBsl;
import com.SWE.ServiceApp.bsl.RefundsBsl;
import com.SWE.ServiceApp.bsl.UserBsl;
import com.SWE.ServiceApp.models.Admin;
import com.SWE.ServiceApp.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class RefundsController {
    private RefundsBsl refundsBsl;
    private AdminBsl adminBsl;
    private UserBsl userBsl;
    public RefundsController(AdminBsl adminBsl,UserBsl userBsl){
        refundsBsl=new RefundsBsl();
        this.adminBsl = adminBsl ;
        this.userBsl = userBsl ;
    }
    @GetMapping(value = "/Refund/{name}/{pass}/{serviceName}/{provider}/{amount}")
    public String sendReq(@PathVariable("name") String name,
                        @PathVariable("pass") int pass,
                        @PathVariable("serviceName") String Sname,
                          @PathVariable("provider") String provider,
                        @PathVariable("amount") double amount){
        User currentUser= userBsl.logIn(name,pass);
        if (currentUser==null){
            return "this name not found or password wrong" ;
        }

        if (currentUser==null){
            return "name or pass are wrong " ;
        }
        for (int i=0 ;i < currentUser.listOfPayment_amount.size();i++){
            if ( currentUser.listOfPayment_amount.get(i)==amount &&
               (Sname+"/Provider:"+provider).equals(currentUser.listOfPayment_name.get(i) ) ){
                return refundsBsl.sendReq(currentUser,Sname,amount);
            }
        }
        return "you did not make this transaction " ;
    }
    @GetMapping(value = "/Admin/listofRefund")
    public String get(){
        return refundsBsl.get();
    }
    @PostMapping(value = "/Respons/{name}/{pass}/{reqouestId}/{statue}")
    public String checkReq(@PathVariable("name") String name,
                         @PathVariable("pass") int pass,
                         @PathVariable("reqouestId") int reqouestId,
                         @PathVariable("statue") String statue){
        Admin admin= adminBsl.getAdmin(name,pass) ;
        if (admin==null){
            return  "the admin name or password are wrong" ;
        }
        return  refundsBsl.checkReq(admin,reqouestId,statue);
    }

}

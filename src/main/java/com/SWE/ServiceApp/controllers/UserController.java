package com.SWE.ServiceApp.controllers;
import com.SWE.ServiceApp.bsl.AdminBsl;
import com.SWE.ServiceApp.bsl.UserBsl;
import com.SWE.ServiceApp.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserBsl userBsl ;
    private AdminBsl adminBsl ;
    public UserController(UserBsl userBsl,AdminBsl adminBsl) {
        this.userBsl = userBsl;
        this.adminBsl=adminBsl;
    }

    //////////// ( URL ) sign up functionality ///////////////
    @PostMapping(value = "/User/signup")
    public String addUser(@RequestBody User user){
        return userBsl.signUp(user);
    }
    //////////// ( URL ) sign in /login functionality ///////////////
    @GetMapping(value = "/User/login/{name}/{pass}")
    public User getUser(@PathVariable("name")String name,@PathVariable("pass")int pass ){
        return userBsl.logIn(name,pass);
    }

    //////////// ( URL ) get ComplteTransaction  functionality ///////////////
    @GetMapping(value = "/User/getComplteTransaction/{name}/{pass}")
    public String getComplteTransaction(@PathVariable("name")String name,@PathVariable("pass")int pass  ){
        return userBsl.getComplteTransaction(name,pass) ;
    }
    @GetMapping(value = "/User/getResponse/{name}/{pass}")
    public String getResponse(@PathVariable("name")String name,@PathVariable("pass")int pass  ){
         return userBsl.getResponse(name,pass);
    }
    @GetMapping(value = "/User/getBalance/{name}/{pass}")
    public double getBalance(@PathVariable("name")String name,@PathVariable("pass")int pass  ){
        return userBsl.getBalance(name,pass);
    }
    @GetMapping(value = "/User/check/{name}/{pass}/{nameS}")
    public String  checkDiscount(@PathVariable("name")String name,@PathVariable("pass")int pass,@PathVariable("nameS")String nameS){
        userBsl.setOverallAndSpecific(name ,pass,adminBsl.getOverall(),adminBsl.getSpecific(nameS));
        return adminBsl.checkDiscount(nameS);
    }

}

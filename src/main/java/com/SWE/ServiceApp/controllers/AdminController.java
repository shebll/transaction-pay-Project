package com.SWE.ServiceApp.controllers;


import org.springframework.web.bind.annotation.*;
import com.SWE.ServiceApp.models.Admin;
import com.SWE.ServiceApp.bsl.AdminBsl;

import java.util.Map;

@RestController
public class AdminController {
    private AdminBsl adminBsl ;

    public AdminController(AdminBsl adminBsl) {
        this.adminBsl = adminBsl;
    }

    @PostMapping(value = "/Admin/signup")
    public String addAdmin(@RequestBody Admin admin){
        return adminBsl.add(admin);
    }
    @GetMapping(value = "/Admin/login/{name}/{pass}")
    public Admin getAdmin(@PathVariable("name")String name,@PathVariable("pass")int pass){
        return adminBsl.getAdmin(name,pass);
    }
    @GetMapping(value = "/Admin/search/{name}/{pass}/{nameS}")
    public String searchSrevices(@PathVariable("name")String name,@PathVariable("pass")int pass,@PathVariable("nameS")String nameS){
        return adminBsl.searchSrevices(name,pass,nameS);
    }
    @GetMapping(value = "/Admin/specific/{name}/{pass}/{nameS}/{val}")
    public String addSpecificDiscount(@PathVariable("name")String name,@PathVariable("pass")int pass,@PathVariable("nameS")String nameS, @PathVariable("val")int val){
        return adminBsl.addSpecificDiscount(name,pass,nameS, val);
    }
    @GetMapping(value = "/Admin/overall/{name}/{pass}/{val}")
    public String  addOverallDiscount(@PathVariable("name")String name,@PathVariable("pass")int pass, @PathVariable("val")int val){
        return adminBsl.addOverallDiscount(name,pass,val);
    }
    @GetMapping(value = "/Admin/list/{name}/{pass}")
    public Map<String, Integer> getlist(@PathVariable("name")String name, @PathVariable("pass")int pass){
        return adminBsl.getlist(name,pass);
    }

}

package com.SWE.ServiceApp.factory;
import java.util.*;

import com.SWE.ServiceApp.bsl.AdminBsl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactoryService {
    Scanner in = new Scanner(System.in);
    private AdminBsl adminBsl ;

    public FactoryService(AdminBsl adminBsl){
        this.adminBsl = adminBsl;
    }
    @PostMapping(value = "/Facroty/create/{name}/{pass}/{serviceName}/{provider}")
    public String createService(@PathVariable("name")String name,@PathVariable("pass")int pass ,@PathVariable("serviceName")String serviceName, @PathVariable("provider")String provider){
        return  adminBsl.createService(name,pass,serviceName,provider);
    }
}

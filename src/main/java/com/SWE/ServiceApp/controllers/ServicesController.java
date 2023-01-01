package com.SWE.ServiceApp.controllers;
import com.SWE.ServiceApp.bsl.ServicesBsl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Vector;

@RestController
public class ServicesController {
    ServicesBsl servicesBsl;

    public ServicesController(ServicesBsl servicesBsl) {
        this.servicesBsl = servicesBsl;
    }
    @GetMapping(value = "/Services/{name}")
    public String searchSrevices(@PathVariable("name")String name){
          return servicesBsl.searchSrevices(name);
    }
    public void add(String service,String provider){
         servicesBsl.add(service,provider);
    }
    public Map<String, Vector<String>> getMp() {
        return servicesBsl.get();
    }

}

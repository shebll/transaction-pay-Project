package com.SWE.ServiceApp.bsl;
import com.SWE.ServiceApp.models.Services;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Vector;

@Service
public class ServicesBsl {
    Services services=new Services();
    public String searchSrevices(String name){
        if(services.getMp().get(name) != null){
            return (name+"\n"+services.getMp().get(name)+"\n\n");
        }
        else {
            return ("this services not fount."+"\n");
        }
    }
    public Map<String, Vector<String>> get() {
        return services.getMp();
    }
    public void add(String service,String provider){
        Vector<String>vec=new Vector<>();
        vec.add(provider);
        services.getMp().put(service,vec);
    }
}

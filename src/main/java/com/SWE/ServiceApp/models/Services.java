package com.SWE.ServiceApp.models;
import org.springframework.stereotype.Component;

import java.util.*;

public class Services {
    Map<String,Vector<String>> mp = new HashMap<String, Vector<String>>();
    public Services(){
        Vector<String>vec=new Vector<String>();
        vec.add("Vodafone");
        vec.add("Etisalat");
        vec.add("Orange");
        vec.add("We");
        mp.put("Mobile_recharge", vec);
        mp.put("Internet_Payment", vec);
        Vector<String>vec1=new Vector<String>();
        vec1.add("Monthly_receipt");
        vec1.add("Quarter_receipt");
        mp.put("Landline", vec1);
        Vector<String>vec2=new Vector<String>();
        vec2.add("Cancer_Hospital");
        vec2.add("Schools");
        vec2.add("NGOs");
        mp.put("Donations", vec2);
    }

    public Map<String, Vector<String>> getMp() {
        return mp;
    }


}

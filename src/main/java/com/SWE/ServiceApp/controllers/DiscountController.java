package com.SWE.ServiceApp.controllers;


import com.SWE.ServiceApp.bsl.SpecificDiscountBsl;
import com.SWE.ServiceApp.bsl.OverallDiscountBsl;

import java.util.Map;


public class DiscountController {
    private SpecificDiscountBsl specificDiscountBsl;
    private OverallDiscountBsl overallDiscountBsl;
    public DiscountController(SpecificDiscountBsl specificDiscountBsl,OverallDiscountBsl overallDiscountBsl){
        this.specificDiscountBsl=specificDiscountBsl;
        this.overallDiscountBsl=overallDiscountBsl;
    }

    public SpecificDiscountBsl getSpecificDiscountBsl() {
        return specificDiscountBsl;
    }

    public void addSpecificDiscount( String name,  int val){
        specificDiscountBsl.addSpecificDiscount(name, val);
    }
    public Map<String, Integer> getlist(){
        return specificDiscountBsl.get();
    }
    public void setSpecificDiscountBsl(SpecificDiscountBsl specificDiscountBsl) {
        this.specificDiscountBsl = specificDiscountBsl;
    }

    public OverallDiscountBsl getOverallDiscountBsl() {
        return overallDiscountBsl;
    }

    public void setOverallDiscountBsl(OverallDiscountBsl overallDiscountBsl) {
        this.overallDiscountBsl = overallDiscountBsl;
    }
}

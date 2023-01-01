package com.SWE.ServiceApp.bsl;
import com.SWE.ServiceApp.models.Discount;

import java.util.Map;
import java.util.Scanner;

public class SpecificDiscountBsl {
    Scanner in = new Scanner(System.in);
    Discount discount;
    public SpecificDiscountBsl(){
        discount=new Discount();
    }

    public void addSpecificDiscount(String name,int val){
        discount.setSpecificDiscount(name, val);
    }
    public Map<String, Integer> get(){
        return discount.getSpecificDiscount();
    }
    public int getSpecific(String name){
        return discount.getSpecificDiscount().get(name);
    }
}

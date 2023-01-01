package com.SWE.ServiceApp.bsl;

import com.SWE.ServiceApp.models.Discount;
import org.springframework.stereotype.Service;

import java.util.Scanner;
@Service
public class OverallDiscountBsl {
    Scanner in = new Scanner(System.in);
    Discount discount;
    public OverallDiscountBsl(){
        discount=new Discount();
    }
    public void add(){
        int val;
        System.out.println("Please enter discount percentage(10% -> 100%):");
        val=in.nextInt();
        discount.setOverallpercentage(val);
    }
    public void get(){
        System.out.println(discount.getOverallpercentage());
    }
    public int getOverall(){
        return discount.getOverallpercentage();
    }

}

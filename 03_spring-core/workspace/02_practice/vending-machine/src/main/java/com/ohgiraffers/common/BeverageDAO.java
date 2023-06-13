package com.ohgiraffers.common;

import org.springframework.stereotype.Component;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

@Component
public class BeverageDAO {
    private final Map<Integer, Beverage> BeverageMap;
    public BeverageDAO(){
        this.BeverageMap = new HashMap<>();

        this.BeverageMap.put(1,new Beverage(1,"Cola",1000));
        this.BeverageMap.put(2,new Beverage(2, "Sidar",2000));
    }

    public Beverage findBeverageByIndex(int index){
        return BeverageMap.get(index);
    }

    public boolean addBeverage(Beverage  beverage){
        int before = BeverageMap.size();
        BeverageMap.put(beverage.getIndex(),beverage);

        int after= BeverageMap.size();

        return before<after ? true:false;


    }

}

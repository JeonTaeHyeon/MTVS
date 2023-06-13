package com.ohgiraffers.annotation;

public class CheckPrice {
    public void checkMoney(int price, int money){
        if(money<price){
            throw new IllegalArgumentException("Not Enough money to purchase beverage.");
        }
    }
}

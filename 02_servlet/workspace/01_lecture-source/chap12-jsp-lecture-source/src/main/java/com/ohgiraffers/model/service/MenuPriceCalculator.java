package com.ohgiraffers.model.service;

public class MenuPriceCalculator {
    public int calcOrderPrice(String menu, int amount) {
        int orderPrice = 0;
        switch (menu) {
            case "햄버거":
                orderPrice = 6000 * amount;
                break;
            case "짜장면":
                orderPrice = 7000 * amount;
                break;
            case "짬뽕":
                orderPrice = 8000 * amount;
                break;
            case "순댓국":
                orderPrice = 5000 * amount;
                break;
        }
        return orderPrice;
    }
}

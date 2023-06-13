package com.ohgiraffers.common;

import com.ohgiraffers.annotation.CheckPrice;
import com.ohgiraffers.annotation.ContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringJUnitConfig(classes = {ContextConfiguration.class})
public class BerverageDAOTests {

    @Autowired
    private BeverageDAO beverageDAO;

    @Test
    public void TestNotNull() {
        assertNotNull(beverageDAO);
    }

    @Test
    public void testPurchase() {
        int money = 1000;

        CheckPrice checkPrice = new CheckPrice();
        Beverage beverage = beverageDAO.findBeverageByIndex(2);

        System.out.println(assertThrows(IllegalArgumentException.class,
                ()-> checkPrice.checkMoney(beverage.getPrice(), money)));
    }
}

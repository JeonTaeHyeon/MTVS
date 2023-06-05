package com.practice;

public class Application {
    public static void main(String[] args) {
        lambda.Sum sum=(x,y)->x+y;
        System.out.println(sum.sumtwonumber(10,20));
    }
}

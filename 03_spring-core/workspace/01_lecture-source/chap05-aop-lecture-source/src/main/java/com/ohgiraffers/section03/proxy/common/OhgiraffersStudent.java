package com.ohgiraffers.section03.proxy.common;

public class OhgiraffersStudent implements Student {
    @Override
    public void study(int hour) {
        System.out.println(hour + "시간 동안 공부합니다.");
    }
}

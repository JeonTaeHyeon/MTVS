package com.ogrp.section01.thread;

public class Car extends Thread{
    @Override
    public void run() {
        for (int i = 0; i< 1000; i++){
            System.out.println("Car Driving");
            try {
                Thread.sleep(1);
                //여기서 에러 발생하면 catch block으로 이동

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

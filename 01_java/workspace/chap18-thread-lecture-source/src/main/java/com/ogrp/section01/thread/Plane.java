package com.ogrp.section01.thread;

public class Plane implements Runnable {
    //Runnable에서는 run method를 반드시 추가해줘야됨

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("plane flight");

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

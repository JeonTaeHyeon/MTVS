package com.ogrp.section01.thread;

public class Application {
    public static void main(String[] args) {

        /*
        수업 목표 : 쓰레드에 대해 이해할 수 있다.

        필기 .
            프로세스(process)란 실행중인 프로그램이라고 할 수 있다.
            즉, 프로그램을 운영체제의 메모리와 cpu를 할당받아 실행되는 단위

            쓰레드(thread)란? 프로세스 내에서 실제로 작업을 수행하는 주체를 의미한다.
            모든 프로세스는 한 개 이상의 쓰레드를 가진다.
            두 개 이상의 쓰레드를 갖는 프로세스를 멀티 쓰레드라고 한다.

            1. Thread 클래스를 상속받는 방법
            2. Runnable 인터페이스를 상속받는 방법
         */

//        Car car=new Car();
//        Tank tank =new Tank();
//        Plane plane = new Plane();
        //위처럼 객체를 미리 생성해서 사용할 수 있고
        //혹은 아래처럼 생성할 때 new키워드를 통해 Thread를 사용할 수 있음.

        Thread t1 =new Car();
        Thread t2 =new Tank();
        Thread t3 =new Thread(new Plane());//Runnable을 사용하면 기본생성자를 사용할 수 없고 Runnable 객체를 상속받는 생성자를 사용해야 함.

//        t1.run();
//        t2.run();
//        t3.run();

        //얘는 method로써 동작하고 있는데 thread로 작동하게 하려면 start를 사용해야됨

        t1.start();
        t2.start();
        t3.start();

        //start를 사용하면 출력 순서가 뒤죽박죽이 됨
        //하나의 thread마다 개별적으로 동작하는 stack이 생성됨
        //하나의 프로세스는 동작중이 thread가 하나라도 있으면 종료되지 않기 때문에 main이 종료되어도 계속 동작함
        //모든 thread가 종료되어야만 프로세스가 종료됨

        System.out.println("main 종료됨");




    }
}

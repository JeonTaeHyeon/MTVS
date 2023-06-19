package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class application {
    public static void main(String[] args) {

        ApplicationContext context=
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        View view = context.getBean("view", View.class);
//
//        System.out.println("=========================findAllMembers=========================");
//        view.findAllMembers();

        System.out.println("=========================findMemberById=========================");
        view.findMemberById();

    }
}

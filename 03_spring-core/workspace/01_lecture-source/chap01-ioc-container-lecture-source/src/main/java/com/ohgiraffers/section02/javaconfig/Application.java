package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Member;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextComfiguration.class);
//      a ContextComfiguration.class를 사용하여 클래스 자체의 정보를 다 넘김

        Member member = context.getBean("getMember",Member.class);

        System.out.println("member = " + member);
    }
}

package com.ohgiraffers.annotation;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.BeverageDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context=
                new AnnotationConfigApplicationContext(ContextConfiguration.class);


        String[] beanNames= context.getBeanDefinitionNames();

        for (String beanName:beanNames
             ) {
            System.out.println("beanName = " + beanName);
        }


        BeverageDAO beverageDAO= context.getBean("beverageDAO", BeverageDAO.class);
        //getBean에 들어가는 name은 앞에를 소문자로 바꾼 name을 쓰는게 원칙
        System.out.println(beverageDAO.findBeverageByIndex(1));
    }
}

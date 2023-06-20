package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Locale;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String error404Message=context.getMessage("error.404",null, Locale.US);
        System.out.println("error404Message = " + error404Message);

        String error500Message=context.getMessage("error.500",new Object[]{"여러분",new Date()},Locale.KOREA );
        System.out.println("error500Message = " + error500Message);
    }
}

package com.ohgiraffers.autoconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Configuration
//어떤 properties 파일을 읽은건지 안정해줬는데 되는이유는 default로
//application.properties를 읽기때문
public class SpringConfiguration {

    @Value("${test.value}")
    //같은 property가 있을 때 properties파일이 우선권을 가짐

    public String value;

    @Value("${test.list}")
//    public List<String>list;
    private String[] list;

    @Value("${test.greeting}")
    private String greeting;

    @Value("${test.array}")
    private Set<String> array;

    @Value("${username}")//
//    @Value("${username}") 운영체제의 username이 우선순위를 가짐(시스템 환경변수)
    private String username;


    @Bean
    public Object propertyReadTest(){

//        System.out.println("value = " + value);

//        list.forEach(System.out::println);

//        Arrays.stream(list).forEach(System.out::println);
//        System.out.println("greeting = " + greeting);

        array.forEach(System.out::println);

        System.out.println("username = " + username);

        return new Object();
    }
}

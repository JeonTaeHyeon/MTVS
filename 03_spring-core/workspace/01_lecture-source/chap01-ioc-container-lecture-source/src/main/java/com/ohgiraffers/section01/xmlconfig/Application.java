package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.swing.plaf.metal.MetalMenuBarUI;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context=
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

//        Member member = (Member) context.getBean("member");
//       a object type으로 반환되기 때문에 casting

//        Member member = context.getBean(Member.class);

        Member member = context.getBean("member",Member.class);

//        a 2번째로 받는 인자의 data type으로 return함, 2번째 인자를 주지 않음녀 object 반환

        System.out.println("member = " + member);
//       a member 객체를 직접 만들지 않고도 사용가능함

    }

}

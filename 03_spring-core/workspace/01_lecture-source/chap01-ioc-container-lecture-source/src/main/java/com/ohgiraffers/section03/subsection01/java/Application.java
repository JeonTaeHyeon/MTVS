package com.ohgiraffers.section03.subsection01.java;

import com.ohgiraffers.common.Member;
import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);


        String[] BeanNames = context.getBeanDefinitionNames();

        for (String BeanName:BeanNames
             ) {
            System.out.println("BeanName = " + BeanName);
        }


        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);


        System.out.println("memberDAO = " + memberDAO.findMemberBySequence(1));
        System.out.println(memberDAO.save(new Member(3,"user03","psss03","신사임당")));
        System.out.println("memberDAO = " + memberDAO.findMemberBySequence(3));
    }
}

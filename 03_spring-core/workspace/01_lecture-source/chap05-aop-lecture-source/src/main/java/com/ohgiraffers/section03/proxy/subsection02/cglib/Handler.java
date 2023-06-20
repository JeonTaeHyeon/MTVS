package com.ohgiraffers.section03.proxy.subsection02.cglib;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    private final OhgiraffersStudent student;

    public Handler(OhgiraffersStudent student){
        this.student=student;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("=========공부가 너무 하고싶습니다.===========");

        method.invoke(student, args);
        System.out.println("method = " + method);
        for (Object arg:args){
            System.out.println("전달된 인자 = " + arg);
        }
        //target

        System.out.println("========공부를 마차고 수면학습을 시작합니다=========");

        return proxy;
    }
}

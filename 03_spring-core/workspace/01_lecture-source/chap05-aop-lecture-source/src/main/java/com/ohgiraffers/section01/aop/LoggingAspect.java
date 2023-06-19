package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.sql.SQLOutput;

@Component
@Aspect
public class LoggingAspect {

    /*
    어디에 들어갈건지가 pointCut이고
    언제 들어갈건지가 before after aspect
    공통적으로 사용되는 method를 분리해서 의존성을 낮춤
    log출력할때도 많이 사용함.
     */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    //PointCut 표현식 Service로 끝나는 모든 클래스의 모든 method
    public void logPointCut(){

    }

    @Before("LoggingAspect.logPointCut()")
    //LoggingAspect.logPointCut()위치에서 동작하겠다.
    public void logBefore(JoinPoint joinPoint){
        //joinpoint는 실제 동작하는 method
        System.out.println("Before joinpoint.getTarget() : "+joinPoint.getTarget());
        System.out.println("Before joinpoint.getSignature() : "+joinPoint.getSignature());

        if(joinPoint.getArgs().length>0){
            for(Object param : joinPoint.getArgs()){
                System.out.println(param);
            }
        }
    }

    @After("logPointCut()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After joinpoint.getSignature : "+joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "logPointCut()",returning = "result")
    public void logAfterReturing(JoinPoint joinPoint, Object result){
        System.out.println("after returning result = " + result);
    }

    @AfterThrowing(pointcut = "logPointCut()", throwing = "exception")
    public  void logAfterThrowing(Throwable exception){
        System.out.println("exception message = " + exception.getMessage());
    }
    //exception이 발생해도 after는 동작하고 after returning은 동작하지 않음

    //around는 method가 실행되기 이전과 이후에 대하여 컨트롤할 수 있어서 가장 강력한 기능
    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //사전에 동작할 내용

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();


        //사후에 동작할 내용


        stopWatch.stop();

        System.out.println("메소드 수행에 걸린 시간 : "+ stopWatch.getTotalTimeMillis() + "(ms)");
        return result;
    }

}

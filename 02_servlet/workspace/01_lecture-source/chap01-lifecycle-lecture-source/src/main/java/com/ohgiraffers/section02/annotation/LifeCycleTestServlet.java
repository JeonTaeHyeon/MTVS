package com.ohgiraffers.section02.annotation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/annotation-lifecycle")
// a web.xml에 쓰지 않고 annotation을 사용하여 같은 동작을 하게 함
public class LifeCycleTestServlet extends HttpServlet {

    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    public LifeCycleTestServlet(){
        System.out.println("LifeCycleTestServlet 인스턴스 생성됨 ...");
        // a 브라우저에서 요청을 보냈을 때 instance가 생성됨..
    }

    // a control + o 를 통해 method 추가
    @Override
    public void init() throws ServletException {
        // a 최초로 servlet을 만들때 호출됨
        System.out.println("xml 매핑 init() 메소드 호출 : "+ initCount++);
    }
    // a init은 최초에 한 번 동작함
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("xml 매핑 doGET() 메소드 호출 : "+ serviceCount++);
    }
    //  a doGet 다시 호출함
    @Override
    public void destroy() {
        System.out.println("xml 매핑 destroy() 메소드 호출 : "+destroyCount++);
    }

    // a 우리가 만든 클래스를 tomcat이 쓸 수 있게 만듦 -> container 객체의 lifecycle은 container에 내재되어있음
    // a tomcat은 servlet의 container라고도 불림
    // a tomcat이 켜질때 web.xml에 있는 것들을 한번 싹 읽음
}
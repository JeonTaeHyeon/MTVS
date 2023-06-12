package com.ohgiraffers.section02.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Enumeration<String> sesstionNames = session.getAttributeNames();

        while (sesstionNames.hasMoreElements()) {
            System.out.println("sesstionNames.nextElement() = " + sesstionNames.nextElement());
        }
        // a session에 아직 firstname과 lastname에 대한 정보가 남아있음

        /*
        a 필기.
        a 1. 세션에 만료 시간 설정
        a 2. removeAttrivbute() 로 session의 attribute를 제거한다.
        a 3. invaliddate()를 호출하면 세션이 만료된다.
         */

//        session.setMaxInactiveInterval();


        session.removeAttribute("firstName");
        Enumeration<String>remain=session.getAttributeNames();

        System.out.println("after delete firstname attribute");

        while(remain.hasMoreElements()){
            System.out.println("remain = " + remain.nextElement());
        }

        session.invalidate();
        // a 즉각적으로 session을 사용할 수 없음 (더 이상 session이 유효하지 않음.)

        System.out.println("session.getID() = " + session.getId());

        Enumeration<String>last=session.getAttributeNames();

        System.out.println("after delete firstname attribute");

        while(last.hasMoreElements()) {
            System.out.println("last = " + last.nextElement());
        }
    }
}

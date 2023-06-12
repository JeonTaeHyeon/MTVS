package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    // a redirect로 오는 요청은 반드시 doGet method 사용
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String firstName= (String) req.getAttribute("firstName");
//        String lastName= (String) req.getAttribute("lastName");
//
//        System.out.println("redirect servlet firstName = " + firstName);
//        System.out.println("redirect servlet lastName = " + lastName);

       //  a redirect로 보낸 값들은 저장이 안돼서 null로 표시됨

        Cookie[] cookies=req.getCookies();
        for (Cookie cookie:cookies){
            System.out.println("cookie = " + cookie);

            System.out.println("key = " + cookie.getName());
            // a getName : key return
            System.out.println("value = " + cookie.getValue());
            // a getValue : value return
        }

        System.out.println("redirect servlet 요청 확안 .." );


    }
}

package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession();

        System.out.println("session.getId() = " + session.getId());
        // a redirect된 페이지에서의 session id가 같음
        String firstName= (String)session.getAttribute("firstName");
        String lastName= (String)session.getAttribute("lastName");
        // a return type이 object이기 때문에 casting하여 사용

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);
    }
}

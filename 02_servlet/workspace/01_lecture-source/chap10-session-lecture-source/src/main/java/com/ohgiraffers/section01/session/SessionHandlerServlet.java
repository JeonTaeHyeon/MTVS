package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.stream.ImageInputStreamImpl;
import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName=req.getParameter("firstName");
        String lastName=req.getParameter("lastName");

        System.out.println("lastName = " + lastName);
        System.out.println("firstName = " + firstName);

        HttpSession session=req.getSession();
        System.out.println("session = " + session.getId());

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);



        resp.sendRedirect("redirect");
    }
}

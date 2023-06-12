package com.ohgiraffers.menu.controller;

import com.ohgiraffers.model.service.MenuPriceCalculator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/menu/order")
public class MenuOrderServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // a 요청에 대한 처리
        String menu=req.getParameter("menuName");

        int amount=Integer.parseInt(req.getParameter("amount"));

        System.out.println("menu = " + menu);
        System.out.println("amount = " + amount);


        // a 비지니스 로직
        int orderPrice = new MenuPriceCalculator().calcOrderPrice(menu,amount);

        req.setAttribute("menuName",menu);
        req.setAttribute("amount",amount);
        req.setAttribute("orderPrice",orderPrice);

        RequestDispatcher rd = req.getRequestDispatcher("/jsp/5_response.jsp");
        rd.forward(req,resp);
    }
}

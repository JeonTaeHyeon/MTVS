package com.ohgiraffers.section01.querystring;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.html.HTML;
import java.io.DataInput;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name= req.getParameter("name");
        System.out.println("name = "+name);

        int age= Integer.parseInt(req.getParameter("age"));
        System.out.println("age = "+age);

        String temp = req.getParameter("birthday");

        String[]arr = temp.split("-");
        int year=Integer.parseInt(arr[0]);
        int month=Integer.parseInt(arr[1]);
        int day=Integer.parseInt(arr[2]);

        Calendar calender=new GregorianCalendar(year,month-1,day);

        java.sql.Date birthday=new java.sql.Date(calender.getTimeInMillis());
        System.out.println("birthday : "+birthday);
        System.out.println(birthday instanceof java.sql.Date);

        String gender=req.getParameter("gender");
        System.out.println("gender = "+gender);

        String national=req.getParameter("national");
        System.out.println("national = "+national);

        String[] hobbies = req.getParameterValues("hobbies");
        for (String hobby:hobbies){
            System.out.println("hobby : "+hobby);
        }

        // a 여러개가 동시에 도착하면




    }// a getmethod를 허용하기 위해 doGet method 정의
}

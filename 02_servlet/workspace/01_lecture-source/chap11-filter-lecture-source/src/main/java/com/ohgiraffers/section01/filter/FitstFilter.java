package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
@WebFilter("/first/*")
// a 상위 요청이 first이고 하위 요청이 *인 모든 요청
public class FitstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init method 호출");
    }

    @Override
    public void destroy() {
        System.out.println("destroy method 호출");
    }
    // a servlet은 최초 요청시부터 lifecycle을 시작하고 filter는 서버가 켜질 때 lifecycle이 시작됨.

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter doFilter 호출됨...");

        chain.doFilter(request,response);// a 다음 필터를 호출해주는 역할 더이상 호출할 filter가 없다면 servlet을 호출함

        // a chain이 끝나면 아래에 servlet 이후에 동작할 코드 구현
        System.out.println("servlet 요청 수행 완료");

    }

}

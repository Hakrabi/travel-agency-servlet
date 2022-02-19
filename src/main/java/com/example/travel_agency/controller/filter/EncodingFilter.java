package com.example.travel_agency.controller.filter;


import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private String requestEncoding = "UTF-8";
    private String responseEncoding = "UTF-8";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(requestEncoding);
        response.setCharacterEncoding(responseEncoding);

        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}


package com.example.travel_agency.controller.dto;

import javax.servlet.http.HttpServletRequest;

public class UserDto implements IDto {
    private String name;
    private String login;
    private String password;

    public UserDto(HttpServletRequest request) {
        login    = request.getParameter("login").toLowerCase().trim();
        password = request.getParameter("password");
        name     = request.getParameter("name");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}

package com.example.travel_agency.model.service;

import com.example.travel_agency.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface IAuthService {
    boolean login(HttpServletRequest request);
    void logout(HttpServletRequest request);
    boolean register(User user);
}

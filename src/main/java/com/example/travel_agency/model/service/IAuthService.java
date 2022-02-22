package com.example.travel_agency.model.service;

import com.example.travel_agency.controller.dto.UserDto;
import com.example.travel_agency.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public abstract class IAuthService {
    protected String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public abstract boolean login(HttpServletRequest request);
    public abstract void logout(HttpServletRequest request);
    public abstract boolean register(UserDto userDto);
}

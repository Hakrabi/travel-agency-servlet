package com.example.travel_agency.model.service;

import com.example.travel_agency.controller.dto.UserDto;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.exception.AppException;

import javax.servlet.http.HttpServletRequest;

public abstract class IAuthService {
    protected String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public abstract boolean login(HttpServletRequest request) throws AppException;
    public abstract void logout(HttpServletRequest request) throws AppException;
    public abstract boolean register(UserDto userDto) throws AppException;
}

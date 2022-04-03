package com.example.travel_agency.controller.command.post.common;

import com.example.travel_agency.model.constant.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.exception.AppException;
import com.example.travel_agency.model.service.impl.AuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        AuthService authService = new AuthService();
        authService.logout(request);

        return Path.REDIRECT + Path.HOME;
    }
}

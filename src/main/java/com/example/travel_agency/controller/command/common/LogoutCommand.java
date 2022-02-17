package com.example.travel_agency.controller.command.common;

import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.service.impl.AuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        AuthService.getInstance().logout(request);

        return Path.REDIRECT + Path.HOME;
    }
}

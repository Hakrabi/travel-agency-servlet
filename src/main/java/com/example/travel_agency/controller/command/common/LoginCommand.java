package com.example.travel_agency.controller.command.common;

import com.example.travel_agency.controller.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.service.impl.AuthService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        boolean successful = AuthService.getInstance().login(request, login,password);

        if (successful) {
            response.sendRedirect(Path.PAGE_TOURS);
        } else {
            response.sendRedirect(Path.PAGE_LOGIN_FAILED);
        }
        return "redirect";
    }
}

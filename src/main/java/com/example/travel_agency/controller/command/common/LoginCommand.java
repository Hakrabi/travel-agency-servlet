package com.example.travel_agency.controller.command.common;

import com.example.travel_agency.controller.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.service.impl.AuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        boolean successful = AuthService.getInstance().login(request);
        String redirectTo;

        System.out.println(successful);
        if (successful) {
            redirectTo = Path.HOME;
        } else {
            redirectTo = Path.LOGIN + "?error=true";
        }

        return Path.REDIRECT + redirectTo;
    }
}

package com.example.travel_agency.controller.command.common;

import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.service.impl.AuthService;
import com.example.travel_agency.model.validation.IValidator;
import com.example.travel_agency.model.validation.LoginValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        IValidator validator = new LoginValidator();

        if (!validator.validate(request)) {

            return Path.PAGE_LOGIN;
        }


        if (!AuthService.getInstance().login(request)){
            return Path.PAGE_LOGIN;
        }

        return Path.REDIRECT + Path.HOME;
    }
}

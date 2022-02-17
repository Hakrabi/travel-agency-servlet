package com.example.travel_agency.controller.command.common;

import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.entity.builder.EntityBuilderFactory;
import com.example.travel_agency.model.service.impl.AuthService;
import com.example.travel_agency.model.validation.IValidator;
import com.example.travel_agency.model.validation.LoginValidator;
import com.example.travel_agency.model.validation.RegistrationValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        IValidator validator = new RegistrationValidator();

        if (!validator.validate(request)) {
            return Path.PAGE_REGISTRATION;
        }

        if (!AuthService.getInstance().register(request)){
            return Path.PAGE_REGISTRATION;
        }

        if (!AuthService.getInstance().login(request)){
            return Path.PAGE_LOGIN;
        }

        return Path.REDIRECT + Path.HOME;
    }
}

package com.example.travel_agency.controller.command.post.common;

import com.example.travel_agency.controller.dto.UserDto;
import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.service.impl.AuthService;
import com.example.travel_agency.model.validation.IValidator;
import com.example.travel_agency.model.validation.RegistrationValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        UserDto userDto = new UserDto(request);
        IValidator<UserDto> validator = new RegistrationValidator();

        if (!validator.validate(userDto)) {
            request.getSession().setAttribute("error", validator.getErrorMsg());
            return Path.PAGE_REGISTRATION;
        }

        AuthService authService = new AuthService();
        if (!authService.register(userDto)){
            request.getSession().setAttribute("error", authService.getErrorMsg());
            return Path.PAGE_REGISTRATION;
        }

        if (!authService.login(request)){
            request.getSession().setAttribute("error", authService.getErrorMsg());
            return Path.PAGE_LOGIN;
        }

        return Path.REDIRECT + Path.HOME;
    }
}

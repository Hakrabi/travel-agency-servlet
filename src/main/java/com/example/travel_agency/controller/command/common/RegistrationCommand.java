package com.example.travel_agency.controller.command.common;

import com.example.travel_agency.controller.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.entity.builder.EntityBuilderFactory;
import com.example.travel_agency.model.service.impl.AuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        User user = EntityBuilderFactory.getUserBuilder().build(request);

        boolean successful = AuthService.getInstance().register(user);
        String redirectTo;

        System.out.println(successful);
        if (successful) {
            AuthService.getInstance().login(request);
            redirectTo = Path.HOME;
        } else {
            redirectTo = Path.REGISTRATION + "?error=true";
        }

        return Path.REDIRECT + redirectTo;
    }
}

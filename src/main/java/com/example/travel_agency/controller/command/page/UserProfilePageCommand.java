package com.example.travel_agency.controller.command.page;

import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.controller.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserProfilePageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

//        String id = request.getParameter("id");
//        User user = (User) request.getSession().getAttribute("user");
//
//        user.

        return Path.PAGE_USER_PROFILE;
    }
}

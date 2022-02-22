package com.example.travel_agency.controller.command.get;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserListPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserService();

        List<User> userList = userService.findAll();
        request.setAttribute("userList", userList);

        return Path.PAGE_USER_LIST;
    }
}

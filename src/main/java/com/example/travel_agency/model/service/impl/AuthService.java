package com.example.travel_agency.model.service.impl;

import com.example.travel_agency.controller.dto.UserDto;
import com.example.travel_agency.model.constants.Errors;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.entity.mapper.EntityMapperFactory;
import com.example.travel_agency.model.service.IAuthService;
import com.example.travel_agency.model.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class AuthService extends IAuthService {

    @Override
    public boolean login(HttpServletRequest request) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        IUserService userService = new UserService();
        User user = userService.read(login);

        if(user == null) {
            errorMsg = Errors.Login.USER_NOT_FOUND;
            return false;
        }
        if(!password.equals(user.getPassword())) {
            errorMsg = Errors.Login.WRONG_PASSWORD;
            return false;
        }
        if(user.getBlocked()) {
            errorMsg = Errors.Login.USER_BLOCKED;
            return false;
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return true;

    }

    @Override
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    @Override
    public boolean register(UserDto userDto) {

        String login = userDto.getLogin();

        IUserService userService = new UserService();
        if(userService.read(login) != null) {
            errorMsg = Errors.Registration.LOGIN_EXISTS;
            return false;
        }

        User user = null;
        try {
            user = EntityMapperFactory.getUserMapper().map(userDto);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        user.setUserRoleId((short) 3);

        try {
            userService.create(user);
            return true;
        } catch (Exception e) {
            user.setId(null);
            return false;
        }
    }
}

package com.example.travel_agency.model.service.impl;

import com.example.travel_agency.controller.dto.UserDto;
import com.example.travel_agency.model.constant.Errors;
import com.example.travel_agency.model.constant.Logs;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.entity.mapper.EntityMapperFactory;
import com.example.travel_agency.model.exception.AppException;
import com.example.travel_agency.model.service.IAuthService;
import com.example.travel_agency.model.service.IUserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class AuthService extends IAuthService {

    private static Logger logger = Logger.getLogger(AuthService.class);

    @Override
    public boolean login(HttpServletRequest request) throws AppException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        IUserService userService = new UserService();
        User user = userService.read(login);

        if (user == null) {
            errorMsg = Errors.Login.USER_NOT_FOUND;
            return false;
        }
        if (!password.equals(user.getPassword())) {
            errorMsg = Errors.Login.WRONG_PASSWORD;
            return false;
        }
        if (user.getBlocked()) {
            errorMsg = Errors.Login.USER_BLOCKED;
            return false;
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        logger.info(Logs.AuthService.USER_LOGIN_SUCCESS + user.getId());

        return true;

    }

    @Override
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            logger.info(Logs.AuthService.USER_LOGOUT_SUCCESS + user.getId());
            session.invalidate();
        }
    }

    @Override
    public boolean register(UserDto userDto) throws AppException {

        String login = userDto.getLogin();

        IUserService userService = new UserService();
        if (userService.read(login) != null) {
            errorMsg = Errors.Registration.LOGIN_EXISTS;
            return false;
        }

        User user;
        try {
            user = EntityMapperFactory.getUserMapper().map(userDto);
            user.setUserRoleId((short) 3);

            Long id = userService.create(user);
            logger.info(Logs.AuthService.USER_REGISTRATION_SUCCESS + id);

            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
}

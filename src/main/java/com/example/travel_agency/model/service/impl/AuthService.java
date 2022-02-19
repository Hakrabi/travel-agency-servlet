package com.example.travel_agency.model.service.impl;

import com.example.travel_agency.model.constants.Errors;
import com.example.travel_agency.model.database.dao.IUserDao;
import com.example.travel_agency.model.database.dao.factory.IDaoFactory;
import com.example.travel_agency.model.database.dao.factory.JdbcDaoFactory;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.entity.builder.EntityBuilderFactory;
import com.example.travel_agency.model.service.IAuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class AuthService implements IAuthService {

    private static AuthService instance = null;
    private static IUserDao userDao;


    private AuthService(){
        //private constructor
    }

    public static AuthService getInstance(){
        if (instance==null){
            instance = new AuthService();
            IDaoFactory daoFactory = new JdbcDaoFactory();
            userDao = daoFactory.getUserDao();
        }

        return instance;
    }

    @Override
    public boolean login(HttpServletRequest request) {

        String login = request.getParameter("login").toLowerCase().trim();
        String password = request.getParameter("password");

        User user = userDao.read(login);

        if(user == null) {
            request.setAttribute(Errors.ERROR_ATTRIBUTE, Errors.Login.USER_NOT_FOUND);
            return false;
        }
        System.out.println(password);
        System.out.println(user.getPassword());
        if(!password.equals(user.getPassword())) {
            request.setAttribute(Errors.ERROR_ATTRIBUTE, Errors.Login.WRONG_PASSWORD);
            return false;
        }
        if(user.getBlocked()) {
            request.setAttribute(Errors.ERROR_ATTRIBUTE, Errors.Login.USER_BLOCKED);
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
    public boolean register(HttpServletRequest request) {

        String login = request.getParameter("login").toLowerCase().trim();

        if(userDao.read(login) != null) {
            request.setAttribute(Errors.ERROR_ATTRIBUTE, Errors.Registration.LOGIN_EXISTS);
            return false;
        }

        User user = null;
        try {
            user = EntityBuilderFactory.getUserBuilder().build(request);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        user.setUserRoleId((short) 3);

        try {
            userDao.create(user);
            return true;
        } catch (Exception e) {
            user.setId(null);
            return false;
        }
    }
}

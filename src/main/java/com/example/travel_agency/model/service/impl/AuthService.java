package com.example.travel_agency.model.service.impl;

import com.example.travel_agency.model.database.dao.IUserDao;
import com.example.travel_agency.model.database.dao.factory.IDaoFactory;
import com.example.travel_agency.model.database.dao.factory.JdbcDaoFactory;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.service.IAuthService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

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
    public boolean login(HttpServletRequest request, String login, String password) {
        try {
            request.login(login, password);
            return true;
        } catch (ServletException e) {
            return false;
        }
    }

    @Override
    public void logout(HttpServletRequest request) {
        try {
            request.logout();
        } catch (ServletException e) {
            System.out.println("bad logout");
        }
    }

    @Override
    public boolean register(User user) {
//        user.setPassword(PasswordEncoder.encodePassword(user.getPassword()));
        user.setUser_role_id((short) 1);
        try {
            userDao.create(user);
            return true;
        } catch (Exception e) {
            user.setId(null);
            return false;
        }
    }
}

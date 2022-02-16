package com.example.travel_agency.model.service.impl;

import com.example.travel_agency.model.database.dao.ITourDao;
import com.example.travel_agency.model.database.dao.IUserDao;
import com.example.travel_agency.model.database.dao.factory.IDaoFactory;
import com.example.travel_agency.model.database.dao.factory.JdbcDaoFactory;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.service.IAuthService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        // error handler
//        String errorMessage;
//        String forward = Path.PAGE_LOGIN;

        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
//            errorMessage = "Login or password can't be empty";
//            request.setAttribute("errorMessage", errorMessage);
//            return forward;
            return false;
        }

        IDaoFactory factory = new JdbcDaoFactory();
        IUserDao userDao = factory.getUserDao();

        User user = userDao.read(login);
        System.out.println(user.getPassword());
        if (user.getLogin() == null || password.equals(user.getPassword())) {
//            errorMessage = "Cannot find user with such login or password";
//            request.setAttribute("errorMessage", errorMessage);
            return false;
        } else {
//            Role userRole = Role.getRole(user);
//
//            if (userRole == Role.ADMIN) {
//                forward = Path.COMMAND_SHOW_USERS;
//            }
//
//            if (userRole == Role.CLIENT) {
//                forward = Path.COMMAND_ACCOUNT;
//            }

            session.setAttribute("user", user);
//            session.setAttribute("userRole", userRole);
        }
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

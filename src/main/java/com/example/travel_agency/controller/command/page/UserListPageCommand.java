package com.example.travel_agency.controller.command.page;

import com.example.travel_agency.controller.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.database.dao.IUserDao;
import com.example.travel_agency.model.database.dao.factory.IDaoFactory;
import com.example.travel_agency.model.database.dao.factory.JdbcDaoFactory;
import com.example.travel_agency.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserListPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        IDaoFactory factory = new JdbcDaoFactory();
        IUserDao userDao = factory.getUserDao();

        List<User> userList = userDao.findAll();
        request.setAttribute("userList", userList);

        return Path.PAGE_USER_LIST;
    }
}

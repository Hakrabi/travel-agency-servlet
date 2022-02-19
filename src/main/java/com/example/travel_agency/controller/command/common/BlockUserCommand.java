package com.example.travel_agency.controller.command.common;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.model.database.dao.IUserDao;
import com.example.travel_agency.model.database.dao.factory.IDaoFactory;
import com.example.travel_agency.model.database.dao.factory.JdbcDaoFactory;
import com.example.travel_agency.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class BlockUserCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        IDaoFactory daoFactory = new JdbcDaoFactory();
        IUserDao userDao = daoFactory.getUserDao();

        String idParam = request.getParameter("id");
        String blockParam = request.getParameter("block");

        Long id = Long.valueOf(idParam);
        Boolean block = Boolean.valueOf(blockParam);

        userDao.changeUserBlock(id, block);

        return Path.REDIRECT + Path.USER_LIST;
    }
}

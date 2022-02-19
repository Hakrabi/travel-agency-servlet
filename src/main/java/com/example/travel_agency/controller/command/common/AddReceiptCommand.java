package com.example.travel_agency.controller.command.common;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.model.database.dao.IReceiptDao;
import com.example.travel_agency.model.database.dao.factory.IDaoFactory;
import com.example.travel_agency.model.database.dao.factory.JdbcDaoFactory;
import com.example.travel_agency.model.entity.Receipt;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.entity.builder.EntityBuilderFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddReceiptCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return null;
        }

        IDaoFactory factory = new JdbcDaoFactory();
        IReceiptDao receiptDao = factory.getReceiptDao();

        Receipt receipt = EntityBuilderFactory.getReceiptBuilder().build(request);

        Long id = receiptDao.create(receipt);

        return Path.REDIRECT + Path.USER_PROFILE;

    }
}

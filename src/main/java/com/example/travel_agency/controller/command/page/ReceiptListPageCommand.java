package com.example.travel_agency.controller.command.page;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.model.database.dao.IReceiptDao;
import com.example.travel_agency.model.database.dao.IUserDao;
import com.example.travel_agency.model.database.dao.factory.IDaoFactory;
import com.example.travel_agency.model.database.dao.factory.JdbcDaoFactory;
import com.example.travel_agency.model.entity.Receipt;
import com.example.travel_agency.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ReceiptListPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        IDaoFactory factory = new JdbcDaoFactory();
        IReceiptDao receiptDao = factory.getReceiptDao();

        List<Receipt> receiptList = receiptDao.findAll();
        request.setAttribute("receiptList", receiptList);

        return Path.PAGE_RECEIPT_LIST;
    }
}

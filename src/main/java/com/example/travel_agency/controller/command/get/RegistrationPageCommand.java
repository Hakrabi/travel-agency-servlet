package com.example.travel_agency.controller.command.get;

import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.controller.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        IDaoFactory factory = new JdbcDaoFactory();
//        ITourDao tourDao = factory.getTourDao();
//
//        List<Tour> tourList = tourDao.findAll();
//        request.setAttribute("tourList", tourList);

        return Path.PAGE_REGISTRATION;
    }
}

package com.example.travel_agency.controller.command.page;

import com.example.travel_agency.controller.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.database.dao.ITourDao;
import com.example.travel_agency.model.database.dao.factory.IDaoFactory;
import com.example.travel_agency.model.database.dao.factory.JdbcDaoFactory;
import com.example.travel_agency.model.entity.Tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ToursMainPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        IDaoFactory factory = new JdbcDaoFactory();
        ITourDao tourDao = factory.getTourDao();

        List<Tour> tourList = tourDao.findAll();
        request.setAttribute("tourList", tourList);

        return Path.PAGE_TOURS;
    }
}

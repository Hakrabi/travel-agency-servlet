package com.example.travel_agency.controller.command.page;

import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.database.dao.ITourDao;
import com.example.travel_agency.model.database.dao.factory.IDaoFactory;
import com.example.travel_agency.model.database.dao.factory.JdbcDaoFactory;
import com.example.travel_agency.model.entity.Tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingleTourPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        IDaoFactory factory = new JdbcDaoFactory();
        ITourDao tourDao = factory.getTourDao();

        String id = request.getParameter("id");

        Tour tour = tourDao.read(Long.parseLong(id));
        request.setAttribute("tour", tour);

        return Path.PAGE_SINGLE_TOUR;
    }
}

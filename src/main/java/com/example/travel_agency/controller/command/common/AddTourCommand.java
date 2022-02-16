package com.example.travel_agency.controller.command.common;

import com.example.travel_agency.controller.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.database.dao.ITourDao;
import com.example.travel_agency.model.database.dao.factory.IDaoFactory;
import com.example.travel_agency.model.database.dao.factory.JdbcDaoFactory;
import com.example.travel_agency.model.entity.Tour;
import com.example.travel_agency.model.entity.builder.EntityBuilderFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.sql.SQLException;

public class AddTourCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        IDaoFactory factory = new JdbcDaoFactory();
        ITourDao tourDao = factory.getTourDao();

        Tour tour = EntityBuilderFactory.getTourBuilder().build(request);

        Long id = tourDao.create(tour);

        return Path.REDIRECT + Path.SINGLE_TOUR  + "?tourId=" + id;
    }
}

package com.example.travel_agency.controller.command.get;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.model.entity.Tour;
import com.example.travel_agency.model.service.impl.TourService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingleTourPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        TourService tourService = new TourService();

        String id = request.getParameter("id");

        Tour tour = tourService.read(Long.parseLong(id));
        request.setAttribute("tour", tour);

        return Path.PAGE_SINGLE_TOUR;
    }
}

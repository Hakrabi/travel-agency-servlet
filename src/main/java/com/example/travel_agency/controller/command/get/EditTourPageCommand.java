package com.example.travel_agency.controller.command.get;

import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.entity.Tour;
import com.example.travel_agency.model.service.impl.TourService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditTourPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String tourId = request.getParameter("id");

        TourService tourService = new TourService();
        Tour tour = tourService.read(Long.parseLong(tourId));

        request.setAttribute("tour", tour);

        return Path.PAGE_EDIT_TOUR;
    }
}

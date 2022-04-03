package com.example.travel_agency.controller.command.get;

import com.example.travel_agency.model.constant.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.entity.Tour;
import com.example.travel_agency.model.exception.AppException;
import com.example.travel_agency.model.service.impl.TourService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditTourPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {

        String tourId = request.getParameter("id");

        System.out.println("into" + tourId);
        TourService tourService = new TourService();
        Tour tour = tourService.read(Long.parseLong(tourId));

        request.setAttribute("tour", tour);

        return Path.PAGE_EDIT_TOUR;
    }
}

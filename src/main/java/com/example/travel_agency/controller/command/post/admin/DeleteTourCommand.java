package com.example.travel_agency.controller.command.post.admin;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constant.Path;
import com.example.travel_agency.model.exception.AppException;
import com.example.travel_agency.model.service.impl.TourService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteTourCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {

        String tourIdParam = request.getParameter("tourId");
        Long tourId = Long.valueOf(tourIdParam);

        TourService tourService = new TourService();
        tourService.delete(tourId);

        return Path.REDIRECT + Path.TOUR_LIST;
    }
}

package com.example.travel_agency.controller.command.post.admin;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.controller.dto.TourDto;
import com.example.travel_agency.model.constant.Path;
import com.example.travel_agency.model.entity.Tour;
import com.example.travel_agency.model.entity.mapper.EntityMapperFactory;
import com.example.travel_agency.model.exception.AppException;
import com.example.travel_agency.model.service.impl.TourService;
import com.example.travel_agency.model.validation.IValidator;
import com.example.travel_agency.model.validation.TourValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTourCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {

        TourDto tourDto = new TourDto(request);

        IValidator<TourDto> validator = new TourValidator();
        if (!validator.validate(tourDto)) {
            request.getSession().setAttribute("error", validator.getErrorMsg());
            return Path.REDIRECT + Path.ADD_TOUR;
        }

        Tour tour = EntityMapperFactory.getTourMapper().map(tourDto);

        TourService tourService = new TourService();
        Long id = tourService.create(tour);

        return Path.REDIRECT + Path.SINGLE_TOUR  + "?id=" + id;
    }
}

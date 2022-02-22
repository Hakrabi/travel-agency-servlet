package com.example.travel_agency.controller.command.post.admin;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.controller.dto.TourDto;
import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.model.entity.Tour;
import com.example.travel_agency.model.entity.mapper.EntityMapperFactory;
import com.example.travel_agency.model.service.impl.TourService;
import com.example.travel_agency.model.validation.IValidator;
import com.example.travel_agency.model.validation.TourValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditTourCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        TourDto tourDto = new TourDto(request);

        IValidator<TourDto> validator = new TourValidator();
        if (!validator.validate(tourDto)) {
            return Path.PAGE_REGISTRATION;
        }

        Tour tour = EntityMapperFactory.getTourMapper().map(tourDto);

        TourService tourService = new TourService();
        tourService.update(tour);

        return Path.REDIRECT + Path.SINGLE_TOUR  + "?id=" + tour.getId();
    }
}

package com.example.travel_agency.model.entity.builder;

import com.example.travel_agency.model.entity.Tour;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TourBuilder implements IEntityBuilder<Tour>{

    @Override
    public Tour build(ResultSet rs) throws SQLException {
        Tour tour = new Tour();

        tour.setId(rs.getLong("id"));
        tour.setName(rs.getString("name"));
        tour.setDescription(rs.getString("description"));
        tour.setPrice(rs.getBigDecimal("price"));
        tour.setPersons(rs.getShort("person_count"));
        tour.setTour_type_id(rs.getShort("tour_type_id"));
        tour.setHotel_type_id(rs.getShort("hotel_type_id"));
        tour.setHot(rs.getBoolean("hot"));
        tour.setImgUrl(rs.getString("img_url"));

        return tour;
    }

    @Override
    public Tour build(HttpServletRequest req) throws SQLException {
        Tour tour = new Tour();

        String name          = req.getParameter("name");
        String description   = req.getParameter("description");
        BigDecimal price     = BigDecimal.valueOf(Long.parseLong(req.getParameter("price")));
        Short persons        = Short.valueOf(req.getParameter("persons"));
        Short tour_type_id   = Short.valueOf(req.getParameter("tour_type"));
        Short hotel_type_id  = Short.valueOf(req.getParameter("hotel_type"));
//        Boolean hot          = Boolean.valueOf(req.getParameter("hot"));
//        String imgUrl        = req.getParameter("img_url");
        Boolean hot          = true;
        String imgUrl        = "url";

        tour.setName(name);
        tour.setDescription(description);
        tour.setPrice(price);
        tour.setPersons(persons);
        tour.setTour_type_id(tour_type_id);
        tour.setHotel_type_id(hotel_type_id);
        tour.setHot(hot);
        tour.setImgUrl(imgUrl);

        return tour;

    }
}

package com.example.travel_agency.model.entity.mapper;

import com.example.travel_agency.controller.dto.TourDto;
import com.example.travel_agency.model.entity.Tour;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TourMapper implements IEntityMapper<Tour, TourDto> {

    @Override
    public Tour map(ResultSet rs) throws SQLException {
        Tour tour = new Tour();

        tour.setId(rs.getLong("id"));
        tour.setName(rs.getString("name"));
        tour.setDescription(rs.getString("description"));
        tour.setPrice(rs.getBigDecimal("price"));
        tour.setPersons(rs.getShort("persons"));
        tour.setTourTypeId(rs.getShort("tour_type_id"));
        tour.setHotelTypeId(rs.getShort("hotel_type_id"));
        tour.setHot(rs.getBoolean("hot"));
        tour.setImgUrl(rs.getString("img_url"));

        return tour;
    }

    @Override
    public Tour map(TourDto tourDto) throws SQLException {
        Tour tour = new Tour();

        String id            = tourDto.getId();
        String name          = tourDto.getName();
        String description   = tourDto.getDescription();
        BigDecimal price     = BigDecimal.valueOf(Long.parseLong(tourDto.getPrice()));
        Short persons        = Short.valueOf(tourDto.getPersons());
        Short tour_type_id   = Short.valueOf(tourDto.getTourTypeId());
        Short hotel_type_id  = Short.valueOf(tourDto.getHotelTypeId());
        Boolean hot          = Boolean.valueOf(tourDto.getHot());
        String imgUrl        = tourDto.getImgUrl();

        if (id != null){
            tour.setId(Long.valueOf(id));
        }
        tour.setName(name);
        tour.setDescription(description);
        tour.setPrice(price);
        tour.setPersons(persons);
        tour.setTourTypeId(tour_type_id);
        tour.setHotelTypeId(hotel_type_id);
        tour.setHot(hot);
        tour.setImgUrl(imgUrl);

        return tour;

    }
}

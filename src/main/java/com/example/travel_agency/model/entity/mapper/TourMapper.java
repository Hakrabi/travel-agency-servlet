package com.example.travel_agency.model.entity.mapper;

import com.example.travel_agency.controller.dto.TourDto;
import com.example.travel_agency.model.constant.Logs;
import com.example.travel_agency.model.entity.Tour;
import com.example.travel_agency.model.exception.AppException;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TourMapper implements IEntityMapper<Tour, TourDto> {

    private static Logger logger = Logger.getLogger(TourMapper.class);

    @Override
    public Tour map(ResultSet rs) throws AppException {
        Tour tour = new Tour();

        try {
            tour.setId(rs.getLong("id"));
            tour.setName(rs.getString("name"));
            tour.setDescription(rs.getString("description"));
            tour.setPrice(rs.getBigDecimal("price"));
            tour.setPersons(rs.getShort("persons"));
            tour.setTourTypeId(rs.getShort("tour_type_id"));
            tour.setHotelTypeId(rs.getShort("hotel_type_id"));
            tour.setHot(rs.getBoolean("hot"));
            tour.setImgUrl(rs.getString("img_url"));
            tour.setDiscountLimit(rs.getBigDecimal("discount_limit"));
            tour.setDiscountStep(rs.getBigDecimal("discount_step"));

        }  catch (SQLException e) {
            logger.error(Logs.Mapper.TOUR_MAPPER_FAILED, e);
            throw new AppException(Logs.Mapper.TOUR_MAPPER_FAILED, e);
        }


        return tour;
    }

    @Override
    public Tour map(TourDto tourDto) throws AppException {
        Tour tour = new Tour();

        String id                = tourDto.getId();
        String name              = tourDto.getName();
        String description       = tourDto.getDescription();
        BigDecimal price         = BigDecimal.valueOf(Long.parseLong(tourDto.getPrice()));
        Short persons            = Short.valueOf(tourDto.getPersons());
        Short tour_type_id       = Short.valueOf(tourDto.getTourTypeId());
        Short hotel_type_id      = Short.valueOf(tourDto.getHotelTypeId());
        Boolean hot              = Boolean.valueOf(tourDto.getHot());
        String imgUrl            = tourDto.getImgUrl();
        BigDecimal discountLimit = BigDecimal.valueOf(Long.parseLong(tourDto.getDiscountLimit()));
        BigDecimal discountStep  = BigDecimal.valueOf(Long.parseLong(tourDto.getDiscountLimit()));

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
        tour.setDiscountLimit(discountLimit);
        tour.setDiscountStep(discountStep);

        return tour;

    }
}

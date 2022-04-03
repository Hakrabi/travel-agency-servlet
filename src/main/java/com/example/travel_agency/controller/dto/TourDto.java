package com.example.travel_agency.controller.dto;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class TourDto implements IDto{
    private String id;
    private String name;
    private String description;
    private String price;
    private String persons;
    private String tourTypeId;
    private String hotelTypeId;
    private String hot;
    private String imgUrl;
    private String discountLimit;
    private String discountStep;

    public TourDto(HttpServletRequest request) {
        id          = request.getParameter("id");
        name          = request.getParameter("name");
        description   = request.getParameter("description");
        price         = request.getParameter("price");
        persons       = request.getParameter("persons");
        tourTypeId    = request.getParameter("tour_type");
        hotelTypeId   = request.getParameter("hotel_type");
        imgUrl        = request.getParameter("img_url");
        hot           = request.getParameter("hot");
        discountLimit = request.getParameter("discount_limit");
        discountStep  = request.getParameter("discount_step");

        if (hot == null){
            hot = "false";
        }
        if (discountLimit == null){
            discountLimit = "0";
        }
        if (discountStep == null){
            discountStep = "0";
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getPersons() {
        return persons;
    }

    public String getTourTypeId() {
        return tourTypeId;
    }

    public String getHotelTypeId() {
        return hotelTypeId;
    }

    public String getHot() {
        return hot;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDiscountLimit() {
        return discountLimit;
    }

    public String getDiscountStep() {
        return discountStep;
    }
}

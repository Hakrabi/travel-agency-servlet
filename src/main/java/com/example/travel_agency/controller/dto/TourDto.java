package com.example.travel_agency.controller.dto;

import javax.servlet.http.HttpServletRequest;

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
        if (hot == null){
            hot = "false";
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
}

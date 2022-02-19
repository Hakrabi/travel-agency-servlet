package com.example.travel_agency.controller.dto;

import javax.servlet.http.HttpServletRequest;

public class TourDto {
    private String name;
    private String description;
    private String price;
    private String persons;
    private String tour_type_id;
    private String hotel_type_id;
    private String hot;
    private String imgUrl;

    public TourDto(HttpServletRequest request) {

         name          = request.getParameter("name");
         description   = request.getParameter("description");
         price         = request.getParameter("price");
         persons       = request.getParameter("persons");
         tour_type_id  = request.getParameter("tour_type");
         hotel_type_id = request.getParameter("hotel_type");
         hot           = request.getParameter("hot");
         imgUrl        = request.getParameter("img_url");
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

    public String getTour_type_id() {
        return tour_type_id;
    }

    public String getHotel_type_id() {
        return hotel_type_id;
    }

    public String getHot() {
        return hot;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}

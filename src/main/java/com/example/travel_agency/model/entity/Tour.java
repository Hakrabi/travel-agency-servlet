package com.example.travel_agency.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Tour extends Entity{
    private String name;
    private String description;
    private BigDecimal price;
    private Short persons;
    private Short tour_type_id;
    private Short hotel_type_id;
    private Boolean hot;
    private String imgUrl;

    public Tour() {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Short getPersons() {
        return persons;
    }

    public Boolean getHot() {
        return hot;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Short getTour_type_id() {
        return tour_type_id;
    }

    public Short getHotel_type_id() {
        return hotel_type_id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPersons(Short persons) {
        this.persons = persons;
    }

    public void setTour_type_id(Short tour_type_id) {
        this.tour_type_id = tour_type_id;
    }

    public void setHotel_type_id(Short hotel_type_id) {
        this.hotel_type_id = hotel_type_id;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

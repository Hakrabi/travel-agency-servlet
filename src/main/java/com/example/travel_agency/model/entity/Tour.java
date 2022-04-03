package com.example.travel_agency.model.entity;

import java.math.BigDecimal;

public class Tour extends Entity{
    private String name;
    private String description;
    private BigDecimal price;
    private Short persons;
    private Short tourTypeId;
    private Short hotelTypeId;
    private Boolean hot;
    private String imgUrl;
    private BigDecimal discountLimit;
    private BigDecimal discountStep;

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

    public Short getTourTypeId() {
        return tourTypeId;
    }

    public Short getHotelTypeId() {
        return hotelTypeId;
    }

    public BigDecimal getDiscountLimit() {
        return discountLimit;
    }

    public BigDecimal getDiscountStep() {
        return discountStep;
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

    public void setTourTypeId(Short tourTypeId) {
        this.tourTypeId = tourTypeId;
    }

    public void setHotelTypeId(Short hotelTypeId) {
        this.hotelTypeId = hotelTypeId;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setDiscountLimit(BigDecimal discountLimit) {
        this.discountLimit = discountLimit;
    }

    public void setDiscountStep(BigDecimal discountStep) {
        this.discountStep = discountStep;
    }
}

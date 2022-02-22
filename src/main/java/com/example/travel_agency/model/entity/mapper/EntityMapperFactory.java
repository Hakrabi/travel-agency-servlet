package com.example.travel_agency.model.entity.mapper;

public class EntityMapperFactory {

    public static TourMapper getTourMapper(){
        return new TourMapper();
    }

    public static UserMapper getUserMapper() {
        return new UserMapper();
    }

    public static ReceiptMapper getReceiptMapper() {
        return new ReceiptMapper();
    }
}

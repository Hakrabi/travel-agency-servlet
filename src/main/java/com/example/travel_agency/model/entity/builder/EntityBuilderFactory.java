package com.example.travel_agency.model.entity.builder;

public class EntityBuilderFactory {

    public static TourBuilder getTourBuilder(){
        return new TourBuilder();
    }

    public static UserBuilder getUserBuilder() {
        return new UserBuilder();
    }
}

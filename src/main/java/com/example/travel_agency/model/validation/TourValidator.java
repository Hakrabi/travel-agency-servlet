package com.example.travel_agency.model.validation;

import com.example.travel_agency.controller.dto.TourDto;
import com.example.travel_agency.model.constant.Errors;

public class TourValidator extends IValidator<TourDto>{

    private String pricePattern = "^\\d+(,\\d{1,2})?$";
    private String personsPattern = "^\\d{1,2}$";
    private String percentPattern = "^\\d{1,2}$";

    @Override
    public boolean validate(TourDto tourDto) {

        if (tourDto.getName() == null || tourDto.getName().isEmpty() || tourDto.getName().length() > 20){
            errorMsg = Errors.Tour.NAME_NOT_VALID;
            return false;
        }
        if (tourDto.getDescription() == null || tourDto.getDescription().isEmpty() || tourDto.getDescription().length() > 200){
            errorMsg = Errors.Tour.DESC_NOT_VALID;
            return false;
        }
        if (tourDto.getPrice() == null || !tourDto.getPrice().matches(pricePattern)){
            errorMsg = Errors.Tour.PRICE_NOT_VALID;
            return false;
        }
        if (tourDto.getDiscountLimit() == null || !tourDto.getDiscountLimit().matches(percentPattern)
                                               || Integer.parseInt(tourDto.getDiscountLimit()) <= 100){
            errorMsg = Errors.Tour.DISCOUNT_LIMIT_NOT_VALID;
            return false;
        }
        if (tourDto.getDiscountStep() == null || !tourDto.getDiscountStep().matches(percentPattern)
                                              || Integer.parseInt(tourDto.getDiscountLimit()) <= 10){
            errorMsg = Errors.Tour.DISCOUNT_STEP_NOT_VALID;
            return false;
        }
        if (tourDto.getPersons() == null || !tourDto.getPersons().matches(personsPattern)){
            errorMsg = Errors.Tour.PERSONS_NOT_VALID;
            return false;
        }
        if (tourDto.getTourTypeId() == null){
            errorMsg = Errors.Tour.HOTEL_NOT_VALID;
            return false;
        }

        return true;
    }

}
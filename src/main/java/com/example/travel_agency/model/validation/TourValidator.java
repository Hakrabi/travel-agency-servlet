package com.example.travel_agency.model.validation;

import com.example.travel_agency.controller.dto.TourDto;
import com.example.travel_agency.model.constants.Errors;

public class TourValidator extends IValidator<TourDto>{

    private String pricePattern = "^\\d+(,\\d{1,2})?$";
    private String personsPattern = "^\\d{1,2}$";

    @Override
    public boolean validate(TourDto tourDto) {

        if (tourDto.getName() == null || tourDto.getName().isEmpty()){
            errorMsg = Errors.Tour.NAME_NOT_VALID;
            return false;
        }
        if (tourDto.getDescription() == null || tourDto.getDescription().isEmpty()){
            errorMsg = Errors.Tour.DESC_NOT_VALID;
            return false;
        }
        if (tourDto.getPrice() == null || !tourDto.getPrice().matches(pricePattern)){
            errorMsg = Errors.Tour.PRICE_NOT_VALID;
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

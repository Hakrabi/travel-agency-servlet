package com.example.travel_agency.model.validation;

import com.example.travel_agency.controller.dto.TourDto;
import com.example.travel_agency.model.constant.Errors;

public class TourManagerEditValidator extends IValidator<TourDto>{

    private String pricePattern = "^\\d+(,\\d{1,2})?$";

    @Override
    public boolean validate(TourDto tourDto) {
        if (tourDto.getPrice() == null || !tourDto.getPrice().matches(pricePattern)){
            errorMsg = Errors.Tour.PRICE_NOT_VALID;
            return false;
        }

        return true;
    }
}

package com.example.travel_agency.model.validation;

import com.example.travel_agency.controller.dto.IDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract class IValidator<T> {
    protected String errorMsg;
    public abstract boolean validate(T dto);
    public String getErrorMsg() {
        return errorMsg;
    }
}

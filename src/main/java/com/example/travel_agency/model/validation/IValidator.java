package com.example.travel_agency.model.validation;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IValidator {

    boolean validate(HttpServletRequest request);
}

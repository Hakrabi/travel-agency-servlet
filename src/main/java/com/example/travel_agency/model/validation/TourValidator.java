package com.example.travel_agency.model.validation;

import com.example.travel_agency.model.constants.Errors;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class TourValidator implements IValidator{

    private String emailPattern = "^([a-z0-9_.-]+)@([a-z0-9_-]+).([a-z]{2,6})$";
    private String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.-_])(?=\\S+$).{8,}$";
    private String namePattern = "^\\p{Alnum}{3,}$";

    @Override
    public boolean validate(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        String name          = request.getParameter("name");
        String description   = request.getParameter("description");
        BigDecimal price     = BigDecimal.valueOf(Long.parseLong(req.getParameter("price")));
        Short persons        = Short.valueOf(req.getParameter("persons"));
        Short tour_type_id   = Short.valueOf(req.getParameter("tour_type"));
        Short hotel_type_id  = Short.valueOf(req.getParameter("hotel_type"));
//        Boolean hot          = Boolean.valueOf(req.getParameter("hot"));
//        String imgUrl        = req.getParameter("img_url");
        Boolean hot          = true;
        String imgUrl        = "url";

        tour.setName(name);
        tour.setDescription(description);
        tour.setPrice(price);
        tour.setPersons(persons);
        tour.setTour_type_id(tour_type_id);
        tour.setHotel_type_id(hotel_type_id);
        tour.setHot(hot);
        tour.setImgUrl(imgUrl);

        if (login == null || !login.matches(emailPattern)){
            request.setAttribute(Errors.ERROR_ATTRIBUTE, Errors.Registration.EMAIL_NOT_VALID);
            return false;
        }
        if (password == null || !password.matches(passwordPattern)){
            request.setAttribute(Errors.ERROR_ATTRIBUTE, Errors.Registration.PASSWORD_NOT_VALID);
            return false;
        }
        if (name == null || !password.matches(namePattern)){
            request.setAttribute(Errors.ERROR_ATTRIBUTE, Errors.Registration.NAME_NOT_VALID);
            return false;
        }

        return true;
    }

}

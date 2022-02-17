package com.example.travel_agency.model.validation;

import com.example.travel_agency.model.constants.Errors;

import javax.servlet.http.HttpServletRequest;

public class RegistrationValidator implements IValidator{

    private String emailPattern = "^([a-z0-9_.-]+)@([a-z0-9_-]+).([a-z]{2,6})$";
    private String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.-_])(?=\\S+$).{8,}$";
    private String namePattern = "^\\p{Alnum}{3,}$";

    @Override
    public boolean validate(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

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

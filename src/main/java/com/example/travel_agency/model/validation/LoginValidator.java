package com.example.travel_agency.model.validation;

import com.example.travel_agency.model.constants.Errors;

import javax.servlet.http.HttpServletRequest;

public class LoginValidator implements IValidator{

    private String emailPattern = "^([a-z0-9_.-]+)@([a-z0-9_-]+).([a-z]{2,6})$";
    private String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.-_])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || !login.matches(emailPattern)){
            request.setAttribute(Errors.ERROR_ATTRIBUTE, Errors.Login.EMAIL_NOT_VALID);
            return false;
        }
        if (password == null || !password.matches(passwordPattern)){
            request.setAttribute(Errors.ERROR_ATTRIBUTE, Errors.Login.PASSWORD_NOT_VALID);
            return false;
        }

        return true;
    }

}

package com.example.travel_agency.model.validation;

import com.example.travel_agency.controller.dto.UserDto;
import com.example.travel_agency.model.constant.Errors;

public class RegistrationValidator extends IValidator<UserDto> {

    private String emailPattern = "^([a-z0-9_.-]+)@([a-z0-9_-]+).([a-z]{2,6})$";
    private String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.-_])(?=\\S+$).{8,}$";
    private String namePattern = "^\\p{Alnum}{3,}$";

    @Override
    public boolean validate(UserDto userDto) {
        String login    = userDto.getLogin();
        String password = userDto.getPassword();
        String name     = userDto.getName();

        if (login == null || login.length() > 45 || !login.matches(emailPattern)){
            errorMsg = Errors.Registration.EMAIL_NOT_VALID;
            return false;
        }
        if (password == null || password.length() > 32 || !password.matches(passwordPattern)){
            errorMsg =  Errors.Registration.PASSWORD_NOT_VALID;
            return false;
        }
        if (name == null || name.length() > 45 || !password.matches(namePattern)){
            errorMsg = Errors.Registration.NAME_NOT_VALID;
            return false;
        }

        return true;
    }

}

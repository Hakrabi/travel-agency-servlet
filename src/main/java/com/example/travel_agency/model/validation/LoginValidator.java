package com.example.travel_agency.model.validation;

import com.example.travel_agency.controller.dto.UserDto;
import com.example.travel_agency.model.constants.Errors;

public class LoginValidator extends IValidator<UserDto>{

    private String emailPattern = "^([a-z0-9_.-]+)@([a-z0-9_-]+).([a-z]{2,6})$";
    private String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.-_])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(UserDto userDto) {
        String login    = userDto.getLogin();
        String password = userDto.getPassword();

        if (login == null || !login.matches(emailPattern)){
            errorMsg = Errors.Login.EMAIL_NOT_VALID;
            return false;
        }
        if (password == null || !password.matches(passwordPattern)){
            errorMsg = Errors.Login.PASSWORD_NOT_VALID;
            return false;
        }

        return true;
    }

}

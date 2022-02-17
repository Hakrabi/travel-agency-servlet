package com.example.travel_agency.model.constants;

public class Errors {

    public static final String ERROR_ATTRIBUTE = "error";

    public static class Login{
        public static final String EMAIL_NOT_VALID = "emailNotValid";
        public static final String PASSWORD_NOT_VALID = "passwordNotValid";
        public static final String USER_NOT_FOUND = "userNotFound";
        public static final String WRONG_PASSWORD = "wrongPassword";
        public static final String USER_BLOCKED = "userBlocked";
    }

    public static class Registration{
        public static final String EMAIL_NOT_VALID = "emailNotValid";
        public static final String PASSWORD_NOT_VALID = "passwordNotValid";
        public static final String NAME_NOT_VALID = "nameNotValid";
        public static final Object LOGIN_EXISTS = "loginExists";
    }
}

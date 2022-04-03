package com.example.travel_agency.model.constant;

public class Errors {

    public static final String ERROR_ATTRIBUTE = "error";

    public static class Login{
        public static final String EMAIL_NOT_VALID      = "emailNotValid";
        public static final String PASSWORD_NOT_VALID   = "passwordNotValid";
        public static final String USER_NOT_FOUND       = "userNotFound";
        public static final String WRONG_PASSWORD       = "wrongPassword";
        public static final String USER_BLOCKED         = "userBlocked";
    }

    public static class Registration{
        public static final String EMAIL_NOT_VALID      = "emailNotValid";
        public static final String PASSWORD_NOT_VALID   = "passwordNotValid";
        public static final String NAME_NOT_VALID       = "nameNotValid";
        public static final String LOGIN_EXISTS         = "loginExists";
    }

    public static class Tour{
        public static final String NAME_NOT_VALID           = "nameNotValid";
        public static final String DESC_NOT_VALID           = "descNotValid";
        public static final String PRICE_NOT_VALID          = "priceNotValid";
        public static final String DISCOUNT_LIMIT_NOT_VALID = "discountLimitNotValid";
        public static final String DISCOUNT_STEP_NOT_VALID  = "discountStepNotValid";
        public static final String PERSONS_NOT_VALID        = "personsNotValid";
        public static final String TOUR_TYPE_NOT_VALID      = "tourTypeNotValid";
        public static final String HOTEL_NOT_VALID          = "hotelNotValid";
        public static final String HOT_NOT_VALID            = "hotNotValid";
    }
}

package com.example.travel_agency.model.constant;

public class Logs {
    public static class Connection{
        public static final String CONNECTION_FAILED = "Failed to connect to database";
        public static final String CLOSING_FAILED    = "Failed to close connection";
    }

    public static class UserService{
        public static final String CREATE_FAILED            = "Failed to create user";
        public static final String READ_FAILED              = "Failed to read user profile";
        public static final String FIND_ALL_FAILED          = "Failed to find all users";
        public static final String CHANGE_USER_BLOCK_FAILED = "Failed to change user block";

        public static final String CREATE_SUCCESS            = "Success create user ";
        public static final String CHANGE_USER_BLOCK_SUCCESS = "Success change block of user ";
    }

    public static class TourService{
        public static final String READ_FAILED              = "Failed to read tour";
        public static final String CREATE_FAILED            = "Failed to create tour";
        public static final String UPDATE_FAILED            = "Failed to create tour";
        public static final String DELETE_FAILED            = "Failed to delete tour";
        public static final String FIND_ALL_FAILED          = "Failed to find all tours";
        public static final String FIND_ALL_SORT_FAILED     = "Failed to find all tours by sort";
        public static final String GET_SIZE_SORT            = "Failed to get size sort";

        public static final String CREATE_SUCCESS           = "Success create tour ";
        public static final String UPDATE_SUCCESS           = "Success update tour ";
        public static final String DELETE_SUCCESS           = "Success delete tour ";
    }

    public static class ReceiptService{
        public static final String CREATE_FAILED            = "Failed to create receipt";
        public static final String CHANGE_STATUS_FAILED     = "Failed to create receipt";
        public static final String FIND_ALL_FAILED          = "Failed to find all receipts";
        public static final String FIND_ALL_BY_USER_FAILED  = "Failed to find all receipts by user";

        public static final String CREATE_SUCCESS           = "Success create tour ";
        public static final String CHANGE_STATUS_SUCCESS    = "Success update tour ";
    }

    public static class AuthService{
        public static final String USER_LOGIN_SUCCESS        = "Success login user ";
        public static final String USER_REGISTRATION_SUCCESS = "Success registration user ";
        public static final String USER_LOGOUT_SUCCESS       = "Success logout user ";
    }

    public static class Mapper{
        public static final String TOUR_MAPPER_FAILED        = "Failed map tour ";
        public static final String USER_MAPPER_FAILED        = "Failed map user ";
        public static final String RECEIPT_MAPPER_FAILED     = "Failed map receipt ";

    }

}

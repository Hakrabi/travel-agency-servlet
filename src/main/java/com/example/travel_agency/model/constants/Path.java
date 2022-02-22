package com.example.travel_agency.model.constants;

public class Path {
    public static final String PAGE_TOURS = "/tours.jsp";
    public static final String PAGE_LOGIN = "/login.jsp";
    public static final String PAGE_USER_LIST = "/user-list.jsp";
    public static final String PAGE_TOUR_LIST = "/tour-list.jsp";
    public static final String PAGE_RECEIPT_LIST = "/receipt-list.jsp";
    public static final String PAGE_REGISTRATION = "/registration.jsp";
    public static final String PAGE_EDIT_TOUR = "/edit-tour.jsp";
    public static final String PAGE_ADD_TOUR = "/add-tour.jsp";
    public static final String PAGE_SINGLE_TOUR = "/single-tour.jsp";
    public static final String PAGE_USER_PROFILE = "/profile.jsp";
    public static final String PAGE_ERROR_404 = "/page404.jsp";

    public static final String PAGE_LOGIN_FAILED = "/login.jsp?failed=true";


    public static final String APP = "/agency/api";

    //pages URL
    public static final String HOME          = APP +  "/";
    public static final String LOGIN         = APP +  "/login";
    public static final String REGISTRATION  = APP +  "/registration";
    public static final String TOUR_LIST     = APP +  "/tour-list";
    public static final String USER_LIST     = APP +  "/user-list";
    public static final String RECEIPT_LIST  = APP +  "/receipt-list";
    public static final String SINGLE_TOUR   = APP +  "/tour";
    public static final String ADD_TOUR      = APP +  "/add-tour";
    public static final String EDIT_TOUR     = APP +  "/edit-tour";
    public static final String USER_PROFILE  = APP +  "/profile";

    //action URL

    public static final String LOGIN_ACTION                 = APP + "/login-action";
    public static final String REGISTRATION_ACTION          = APP + "/registration-action";
    public static final String LOGOUT_ACTION                = APP + "/logout-action";
    public static final String BLOCK_USER                   = APP + "/block-user-action";
    public static final String ADD_RECEIPT_ACTION           = APP + "/add-receipt-action";
    public static final String EDIT_RECEIPT_STATUS_ACTION   = APP + "/edit-receipt-status-action";
    public static final String ADD_TOUR_ACTION              = APP + "/add-tour-action";
    public static final String EDIT_TOUR_ACTION             = APP + "/edit-tour-action";


    public static final String REDIRECT = "redirect";
}

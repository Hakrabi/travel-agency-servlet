package com.example.travel_agency.model.database;

public class Queries{
    public static class User {
        public static final String INSERT       = "INSERT INTO user VALUES(default, ?, ?, ?, ?, false, default);";
        public static final String SELECT_ALL   = "SELECT * FROM user";
        public static final String SELECT_BY_LOGIN = "SELECT * FROM user WHERE login = ?";
        public static final String SELECT_BY_ID = "SELECT * FROM user WHERE id = ?";
        public static final String CHANGE_BLOCK = "UPDATE user SET block = ? WHERE id = ?";
    }

    public static class Tour {
        public static final String INSERT       = "INSERT INTO tour VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, default, default, null);";
        public static final String SELECT_ALL   = "SELECT * FROM tour";
        public static final String SELECT_BY_ID = "SELECT * FROM tour WHERE id = ?";
        public static final String SELECT_ALL_BY_PAGE = "SELECT * FROM tour ORDER BY hot DESC LIMIT ? OFFSET ?";
        public static final String SIZE         = "SELECT COUNT(*) FROM tour";

        public static final String SELECT_ALL_BY_PAGE_SORT = "SELECT * FROM tour ? ORDER BY hot DESC ? LIMIT ? OFFSET ?";
        public static final String ORDER_BY_PRICE_DESC = ", price DESC";
        public static final String ORDER_BY_PRICE_ASC = ", price ASC";
        public static final String ORDER_BY_PERSONS_DESC = ", persons DESC";
        public static final String ORDER_BY_PERSONS_ASC = ", persons ASC";
        public static final String ORDER_BY_HOTEL_DESC = ", hotel DESC";
        public static final String ORDER_BY_HOTEL_ASC = ", hotel ASC";

        public static final String TYPE_ALL = "";
        public static final String WHERE_TYPE_EXCURSION = "WHERE tour_type_id = 1";
        public static final String WHERE_TYPE_VACATION  = "WHERE tour_type_id = 2";
        public static final String WHERE_TYPE_SHOPPING  = "WHERE tour_type_id = 3";



        public static final String UPDATE       = "UPDATE teams SET name = ? WHERE id = ?";
    }

    public static class Receipt {
        public static final String INSERT       = "INSERT INTO receipt VALUES(default, default, ?, ?, default)";
        public static final String SELECT_ALL   = "SELECT * FROM receipt";
        public static final String DELETE       = "DELETE FROM teams WHERE name = ?";
        public static final String SELECT_ONE   = "SELECT * FROM teams WHERE name = ?";
        public static final String UPDATE       = "UPDATE teams SET name = ? WHERE id = ?";
    }

}


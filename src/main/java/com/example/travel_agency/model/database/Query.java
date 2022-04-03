package com.example.travel_agency.model.database;

import java.util.HashMap;
import java.util.Map;

public class Query {
    public static class User {
        public static final String INSERT          = "INSERT INTO user VALUES(default, ?, ?, ?, ?, false, default);";
        public static final String SELECT_ALL      = "SELECT * FROM user";
        public static final String SELECT_BY_LOGIN = "SELECT * FROM user WHERE login = ?";
        public static final String SELECT_BY_ID    = "SELECT * FROM user WHERE id = ?";
        public static final String UPDATE_BLOCK    = "UPDATE user SET block = ? WHERE id = ?";
    }

    public static class Tour {
        public static final String INSERT       = "INSERT INTO tour VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, default, default, default, null);";
        public static final String SELECT_ALL   = "SELECT * FROM tour";
        public static final String SELECT_BY_ID = "SELECT * FROM tour WHERE id = ?";
        public static final String DELETE       = "DELETE FROM tour WHERE id = ?";
        public static final String UPDATE       = "UPDATE tour SET name=?, description=?, price=?, persons=?, " +
                                                  "tour_type_id=?, hotel_type_id=?, hot=?, img_url=?, discount_limit=?, " +
                                                  "discount_step=? WHERE id=?";

        public static class Order{
            public static final String DESC = "DESC";
            public static final String ASC  = "ASC";

            public static final String WHERE_TYPE_EXCURSION = "WHERE tour_type_id = 1";
            public static final String WHERE_TYPE_VACATION  = "WHERE tour_type_id = 2";
            public static final String WHERE_TYPE_SHOPPING  = "WHERE tour_type_id = 3";

            public static final String ORDER_BY_PRICE   = ", price ";
            public static final String ORDER_BY_PERSONS = ", persons ";
            public static final String ORDER_BY_HOTEL   = ", hotel_type_id ";

            private static Map<String, String> orderParams = new HashMap<String, String>();
            static {
                orderParams.put("asc",  ASC);
                orderParams.put("desc", DESC);
            }

            private static Map<String, String> typeParams = new HashMap<String, String>(){{
                put("excursion",    WHERE_TYPE_EXCURSION);
                put("vacation",     WHERE_TYPE_VACATION);
                put("shopping",     WHERE_TYPE_SHOPPING);
            }};

            private static Map<String, String> sortParams = new HashMap<String, String>(){{
                put("price",    ORDER_BY_PRICE);
                put("persons",  ORDER_BY_PERSONS);
                put("hotel",    ORDER_BY_HOTEL);
            }};

            public static String getOrderQuery(String tourTypeParam, String sortParam, String orderParam){
                String sort = sortParams.getOrDefault(sortParam, "");
                String order = "";
                if (!sort.isEmpty()) {
                    order = orderParams.getOrDefault(orderParam, "");
                }
                String tourType = typeParams.getOrDefault(tourTypeParam, "");

                return String.format("SELECT * FROM tour %1$s ORDER BY hot DESC %2$s %3$s LIMIT ? OFFSET ?", tourType, sort, order);
            }

            public static String getOrderTypeSizeQuery(String tourTypeParam){
                String tourType = typeParams.getOrDefault(tourTypeParam, "");

                return String.format("SELECT count(*) FROM tour %1$s", tourType);
            }
        }

    }

    public static class Receipt {
        public static final String INSERT        = "INSERT INTO receipt VALUES(default, default, ?, ?, ?, ?, default)";
        public static final String SELECT_ALL    = "SELECT * FROM receipt";
        public static final String UPDATE_STATUS = "UPDATE receipt SET receipt_status_id = ? WHERE id = ?";
        public static final String SELECT_ALL_BY_USER    = "SELECT * FROM receipt WHERE user_id = ?";
    }

}


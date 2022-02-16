package com.example.travel_agency.model.database.connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Connector {
    private Connector(){
        //private constructor
    }

    private static Connector instance = null;

    public static Connector getInstance(){
        if (instance==null)
            instance = new Connector();
        return instance;
    }

    public Connection getConnection(){
        Context context;
        Connection connection  = null;

        try {
            context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool");
            connection  = dataSource.getConnection();

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }

    public void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

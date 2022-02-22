package com.example.travel_agency.model.database.connection;

import com.example.travel_agency.model.constants.Logs;
import com.example.travel_agency.model.exception.AppException;
import org.apache.log4j.Logger;

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
    private static Logger logger = Logger.getLogger(Connector.class);

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

        } catch (NamingException | SQLException e) {
            logger.fatal(Logs.Connection.CONNECTION_FAILED, e);
            throw new AppException("Connection error", e);
        }

        return connection;
    }

    public void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            logger.fatal(Logs.Connection.CLOSING_FAILED, e);
            throw new AppException("Connection error", e);
        }
    }

}

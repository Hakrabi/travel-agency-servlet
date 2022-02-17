package com.example.travel_agency.model.database;

import com.example.travel_agency.model.database.connection.Connector;
import com.example.travel_agency.model.entity.Entity;
import com.example.travel_agency.model.entity.builder.IEntityBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryExecutor {

    public static Long insert(String query, Object... fields){
        Connection con = Connector.getInstance().getConnection();

        if (con == null)
            return null;

        try {
            PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            int i = 1;
            for (Object field : fields) {
                stmt.setObject(i++, field);
                System.out.println(field);
            }

            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next())
                return rs.getLong(1);

            return null;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        finally {
            Connector.getInstance().closeConnection(con);
        }

    }


    public static <R extends Entity> List<R> getObjects(String query, IEntityBuilder<R> builder, Object... fields) throws SQLException {
        Connection con = Connector.getInstance().getConnection();

        if (con == null)
            return null;

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            List<R> entities = new ArrayList<>();

            int i = 1;
            for (Object field : fields) {
                stmt.setObject(i++, field);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                entities.add(builder.build(rs));
            }

            return entities;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {
            Connector.getInstance().closeConnection(con);
        }
    }

    public static <R extends Entity> R getObject(String query, IEntityBuilder<R> builder, Object... fields) throws SQLException {
        Connection con = Connector.getInstance().getConnection();

        if (con == null)
            return null;

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            Object entity = new Object();

            int i = 1;
            for (Object field : fields) {
                stmt.setObject(i++, field);
            }

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                entity = builder.build(rs);
            }

            return (R) entity;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            Connector.getInstance().closeConnection(con);
        }
    }

    public static Integer getSize(String query) throws SQLException {
        Connection con = Connector.getInstance().getConnection();

        if (con == null)
            return null;

        try {
            PreparedStatement stmt = con.prepareStatement(query);

            Integer size = null;

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                size = rs.getInt(1);
            }

            return size;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            Connector.getInstance().closeConnection(con);
        }
    }

}

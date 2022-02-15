package com.example.travel_agency.model.database;

import com.example.travel_agency.model.database.connection.Connector;
import com.example.travel_agency.model.entity.Entity;
import com.example.travel_agency.model.entity.builder.IEntityBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryExecutor {

    public static Long insert(String query, Object... fields) throws SQLException {
        Connection con = Connector.getInstance().getConnection();
        PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        int i = 1;
        for (Object field : fields) {
            stmt.setObject(i++, field);
        }

        stmt.execute();
        ResultSet rs = stmt.getGeneratedKeys();

        if (rs.next())
            return rs.getLong(1);

        return null;
    }


    public static <R extends Entity> List<R> getObjects(String query, IEntityBuilder<R> builder, Object... fields) throws SQLException {
        Connection con = Connector.getInstance().getConnection();
        PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
    }

    public static <R extends Entity> R getObject(String query, IEntityBuilder<R> builder, Object... fields) throws SQLException {
        Connection con = Connector.getInstance().getConnection();
        PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
    }

}

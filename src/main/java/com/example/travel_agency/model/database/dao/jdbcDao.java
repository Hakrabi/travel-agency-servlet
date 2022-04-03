package com.example.travel_agency.model.database.dao;

import com.example.travel_agency.model.database.connection.Connector;
import com.example.travel_agency.model.entity.Entity;
import com.example.travel_agency.model.entity.mapper.IEntityMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcDao {

    public static Long insert(String query, Object... fields) throws Exception {
        Connection con = Connector.getInstance().getConnection();

        try {
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
        finally {
            Connector.getInstance().closeConnection(con);
        }

    }

    public static int update(String query, Object... fields) throws Exception {
        Connection con = Connector.getInstance().getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement(query);

            int i = 1;
            for (Object field : fields) {
                stmt.setObject(i++, field);
            }

            return stmt.executeUpdate();

        } finally {
            Connector.getInstance().closeConnection(con);
        }
    }

    public static void delete(String query, Long id) throws Exception {
        Connection con = Connector.getInstance().getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setObject(1, id);

            stmt.execute();
        } finally {
            Connector.getInstance().closeConnection(con);
        }
    }


    public static <R extends Entity, D> List<R> getObjects(String query, IEntityMapper<R, D> builder, Object... fields) throws Exception {
        Connection con = Connector.getInstance().getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            List<R> entities = new ArrayList<>();

            int i = 1;
            for (Object field : fields) {
                stmt.setObject(i++, field);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                entities.add(builder.map(rs));
            }

            return entities;

        } finally {
            Connector.getInstance().closeConnection(con);
        }
    }

    public static <R extends Entity, D> R getObject(String query, IEntityMapper<R, D> builder, Object... fields) throws Exception {
        Connection con = Connector.getInstance().getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            Object entity = null;

            int i = 1;
            for (Object field : fields) {
                stmt.setObject(i++, field);
            }

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                entity = builder.map(rs);
            }

            return (R) entity;
        } finally {
            Connector.getInstance().closeConnection(con);
        }
    }

    public static Integer getSize(String query) throws Exception {
        Connection con = Connector.getInstance().getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement(query);

            Integer size = null;

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                size = rs.getInt(1);
            }

            return size;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            Connector.getInstance().closeConnection(con);
        }
    }

}

package com.example.travel_agency.model.entity.builder;

import com.example.travel_agency.model.entity.Entity;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IEntityBuilder<T extends Entity> {
    public T build(ResultSet rs) throws SQLException;
    public T build(HttpServletRequest req) throws SQLException;
}

package com.example.travel_agency.model.entity.mapper;

import com.example.travel_agency.model.entity.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IEntityMapper<T extends Entity, D> {
    public T map(ResultSet rs) throws SQLException;
    public T map(D dto) throws SQLException;
}

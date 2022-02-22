package com.example.travel_agency.model.database.dao;

import com.example.travel_agency.model.entity.Entity;
import com.example.travel_agency.model.entity.mapper.IEntityMapper;

import java.util.List;

public interface IDao {

    Long insert(String query, Object... fields);
    int update(String updQuery, Object... fields);
    <R extends Entity, D> List<R> getObjects(String query, IEntityMapper<R, D> builder, Object... fields);
    <R extends Entity, D> R getObject(String query, IEntityMapper<R, D> builder, Object... fields);
    Integer getSize(String query);
}

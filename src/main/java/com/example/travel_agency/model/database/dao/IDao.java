package com.example.travel_agency.model.database.dao;

import java.io.Serializable;
import java.util.List;

public interface IDao<T, PK extends Serializable> {
    PK create(T t);
    T read(PK id);
    void update(T t);
    void delete(PK id);
    List<T> findAll();
}
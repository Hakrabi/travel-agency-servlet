package com.example.travel_agency.model.service;

import java.io.Serializable;
import java.util.List;

public interface IEntityService<T, PK extends Serializable> {
    PK create(T t);
    T read(PK id);
    void update(T t);
    void delete(PK id);
    List<T> findAll();

    List<T> findAllByPage(Integer page, Integer limit);
    Integer getSize();


}
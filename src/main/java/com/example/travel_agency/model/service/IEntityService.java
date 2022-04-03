package com.example.travel_agency.model.service;

import com.example.travel_agency.model.exception.AppException;

import java.io.Serializable;
import java.util.List;

public interface IEntityService<T, PK extends Serializable> {
    PK create(T t) throws AppException;
    T read(PK id) throws AppException;
    void update(T t) throws AppException;
    void delete(PK id) throws AppException;
    List<T> findAll() throws AppException;




}
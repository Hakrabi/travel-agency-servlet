package com.example.travel_agency.model.service;

import com.example.travel_agency.model.entity.Tour;
import com.example.travel_agency.model.exception.AppException;

import java.util.List;

public interface ITourService extends IEntityService<Tour, Long> {
    List<Tour> findAllByPageSort(Integer page, Integer limit, String sort, String order, String tourType) throws AppException;
    Integer getSizeSort(String tourType) throws AppException;
}

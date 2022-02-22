package com.example.travel_agency.model.service.impl;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.database.Queries;
import com.example.travel_agency.model.database.dao.jdbcDao;
import com.example.travel_agency.model.service.ITourService;
import com.example.travel_agency.model.entity.Tour;
import com.example.travel_agency.model.entity.mapper.EntityMapperFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TourService implements ITourService {
    @Override
    public Long create(Tour tour) {
        Long id = null;
        id = jdbcDao.insert(Queries.Tour.INSERT,
                tour.getName(),
                tour.getDescription(),
                tour.getPrice(),
                tour.getPersons(),
                tour.getTourTypeId(),
                tour.getHotelTypeId(),
                tour.getHot(),
                tour.getImgUrl());

        return id;
    }

    @Override
    public Tour read(Long id) {
        Tour tour = null;
        try {
            tour = jdbcDao.getObject(Queries.Tour.SELECT_BY_ID, EntityMapperFactory.getTourMapper(), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tour;
    }

    @Override
    public void update(Tour tour) {
        jdbcDao.insert(Queries.Tour.UPDATE,
                tour.getName(),
                tour.getDescription(),
                tour.getPrice(),
                tour.getPersons(),
                tour.getTourTypeId(),
                tour.getHotelTypeId(),
                tour.getHot(),
                tour.getImgUrl(),
                tour.getId());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Tour> findAll() {

        List<Tour> tourList = null;
        try {
            tourList = jdbcDao.getObjects(Queries.Tour.SELECT_ALL, EntityMapperFactory.getTourMapper());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tourList;
    }

    @Override
    public List<Tour> findAllByPage(Integer page, Integer limit) {
        List<Tour> tourList = null;
        try {
            tourList = jdbcDao.getObjects(Queries.Tour.SELECT_ALL_BY_PAGE, EntityMapperFactory.getTourMapper(), limit,  page);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tourList;
    }

    @Override
    public Integer getSize() {
        Integer size = 0;
        try {
            size = jdbcDao.getSize(Queries.Tour.SIZE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return size;
    }

    public List<Tour> findAllByPageSort(Integer page, Integer limit, String sort, String order, String tourType) {
        List<Tour> tourList = null;

        try {
            String orderQuery = Queries.Tour.Order.getOrderQuery(tourType, sort, order);
            tourList = jdbcDao.getObjects(orderQuery, EntityMapperFactory.getTourMapper(), limit,  page);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tourList;
    }

    public Integer getSizeSort(String tourType) {
        Integer size = 0;
        try {
            String orderSizeQuery = Queries.Tour.Order.getOrderTypeSizeQuery(tourType);
            size = jdbcDao.getSize(orderSizeQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return size;
    }

}

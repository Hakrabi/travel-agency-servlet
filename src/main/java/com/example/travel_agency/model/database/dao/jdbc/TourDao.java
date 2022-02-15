package com.example.travel_agency.model.database.dao.jdbc;

import com.example.travel_agency.model.database.Queries;
import com.example.travel_agency.model.database.QueryExecutor;
import com.example.travel_agency.model.database.dao.ITourDao;
import com.example.travel_agency.model.entity.Tour;
import com.example.travel_agency.model.entity.builder.EntityBuilderFactory;

import java.sql.SQLException;
import java.util.List;

public class TourDao implements ITourDao {
    @Override
    public Long create(Tour tour) {
        try {
            Long id = QueryExecutor.insert(Queries.Tour.INSERT, EntityBuilderFactory.getTourBuilder());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return id;
    }

    @Override
    public Tour read(Long id) {
        Tour tour = null;
        try {
            tour = QueryExecutor.getObject(Queries.Tour.SELECT_BY_ID, EntityBuilderFactory.getTourBuilder(), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tour;
    }

    @Override
    public void update(Tour tour) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Tour> findAll() {

        List<Tour> tourList = null;
        try {
            tourList = QueryExecutor.getObjects(Queries.Tour.SELECT_ALL, EntityBuilderFactory.getTourBuilder());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tourList;
    }
}

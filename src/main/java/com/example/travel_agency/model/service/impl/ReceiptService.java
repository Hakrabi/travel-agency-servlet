package com.example.travel_agency.model.service.impl;

import com.example.travel_agency.model.database.Queries;
import com.example.travel_agency.model.database.dao.jdbcDao;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.service.IReceiptService;
import com.example.travel_agency.model.entity.Receipt;
import com.example.travel_agency.model.entity.mapper.EntityMapperFactory;

import java.sql.SQLException;
import java.util.List;

public class ReceiptService implements IReceiptService {
    @Override
    public Long create(Receipt receipt) {
        Long id = null;

        id = jdbcDao.insert(Queries.Receipt.INSERT,
                receipt.getUserId(),
                receipt.getTourId());


        return id;
    }

    @Override
    public Receipt read(Long id) {
        return null;
    }

    @Override
    public void update(Receipt receipt) {
    }

    @Override
    public void changeReceiptStatus(Long tourId, Long statusId) {
        jdbcDao.update(Queries.Receipt.UPDATE_STATUS, statusId, tourId);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Receipt> findAll() {
        List<Receipt> receiptList = null;
        try {
            receiptList = jdbcDao.getObjects(Queries.Receipt.SELECT_ALL, EntityMapperFactory.getReceiptMapper());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return receiptList;
    }

    public List<Receipt> findAllByUser(Long userId) {
        List<Receipt> receiptList = null;
        try {
            receiptList = jdbcDao.getObjects(Queries.Receipt.SELECT_ALL_BY_USER, EntityMapperFactory.getReceiptMapper(), userId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return receiptList;
    }

    @Override
    public List<Receipt> findAllByPage(Integer page, Integer limit) {
        return null;
    }

    @Override
    public Integer getSize() {
        return null;
    }
}

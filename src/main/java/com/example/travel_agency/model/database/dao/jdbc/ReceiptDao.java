package com.example.travel_agency.model.database.dao.jdbc;

import com.example.travel_agency.model.database.dao.IReceiptDao;
import com.example.travel_agency.model.entity.Receipt;

import java.util.List;

public class ReceiptDao implements IReceiptDao {
    @Override
    public Long create(Receipt receipt) {
        return null;
    }

    @Override
    public Receipt read(Long id) {
        return null;
    }

    @Override
    public void update(Receipt receipt) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Receipt> findAll() {
        return null;
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

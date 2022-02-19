package com.example.travel_agency.model.database.dao.jdbc;

import com.example.travel_agency.model.database.Queries;
import com.example.travel_agency.model.database.QueryExecutor;
import com.example.travel_agency.model.database.dao.IReceiptDao;
import com.example.travel_agency.model.entity.Receipt;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.entity.builder.EntityBuilderFactory;

import java.sql.SQLException;
import java.util.List;

public class ReceiptDao implements IReceiptDao {
    @Override
    public Long create(Receipt receipt) {
        Long id = null;

        id = QueryExecutor.insert(Queries.Receipt.INSERT,
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
    public void delete(Long id) {

    }

    @Override
    public List<Receipt> findAll() {
        List<Receipt> receiptList = null;
        try {
            receiptList = QueryExecutor.getObjects(Queries.Receipt.SELECT_ALL, EntityBuilderFactory.getReceiptBuilder());
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

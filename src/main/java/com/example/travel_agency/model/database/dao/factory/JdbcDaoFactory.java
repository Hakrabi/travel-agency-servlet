package com.example.travel_agency.model.database.dao.factory;

import com.example.travel_agency.model.database.dao.IReceiptDao;
import com.example.travel_agency.model.database.dao.ITourDao;
import com.example.travel_agency.model.database.dao.IUserDao;
import com.example.travel_agency.model.database.dao.jdbc.ReceiptDao;
import com.example.travel_agency.model.database.dao.jdbc.TourDao;
import com.example.travel_agency.model.database.dao.jdbc.UserDao;

public class JdbcDaoFactory implements IDaoFactory{
    @Override
    public IReceiptDao getReceiptDao() {
        return new ReceiptDao();
    }

    @Override
    public IUserDao getUserDao() {
        return new UserDao();
    }

    @Override
    public ITourDao getTourDao() {
        return new TourDao();
    }
}

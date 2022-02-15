package com.example.travel_agency.model.database.dao.factory;

import com.example.travel_agency.model.database.dao.IReceiptDao;
import com.example.travel_agency.model.database.dao.ITourDao;
import com.example.travel_agency.model.database.dao.IUserDao;

public interface IDaoFactory {
    IReceiptDao getReceiptDao();
    IUserDao getUserDao();
    ITourDao getTourDao();
}

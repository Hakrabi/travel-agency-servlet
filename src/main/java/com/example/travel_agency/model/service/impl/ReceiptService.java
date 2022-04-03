package com.example.travel_agency.model.service.impl;

import com.example.travel_agency.model.constant.Logs;
import com.example.travel_agency.model.database.Query;
import com.example.travel_agency.model.database.dao.jdbcDao;
import com.example.travel_agency.model.entity.Receipt;
import com.example.travel_agency.model.entity.mapper.EntityMapperFactory;
import com.example.travel_agency.model.exception.AppException;
import com.example.travel_agency.model.service.IReceiptService;
import org.apache.log4j.Logger;

import java.util.List;

public class ReceiptService implements IReceiptService {

    private static Logger logger = Logger.getLogger(ReceiptService.class);

    @Override
    public Long create(Receipt receipt) {
        Long id;

        try {
            id = jdbcDao.insert(Query.Receipt.INSERT,
                    receipt.getUserId(),
                    receipt.getTourId());

            logger.info(Logs.ReceiptService.CREATE_SUCCESS + id);

        } catch (Exception e) {
            logger.error(Logs.ReceiptService.CREATE_FAILED, e);
            throw new AppException(Logs.ReceiptService.CREATE_FAILED, e);
        }

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
    public void changeReceiptStatus(Long receiptId, Long statusId) {
        try {
            jdbcDao.update(Query.Receipt.UPDATE_STATUS, statusId, receiptId);

            logger.info(Logs.ReceiptService.CHANGE_STATUS_SUCCESS + receiptId);
        } catch (Exception e) {
            logger.error(Logs.ReceiptService.CHANGE_STATUS_FAILED, e);
            throw new AppException(Logs.ReceiptService.CHANGE_STATUS_FAILED, e);
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Receipt> findAll() {
        List<Receipt> receiptList;

        try {
            receiptList = jdbcDao.getObjects(Query.Receipt.SELECT_ALL, EntityMapperFactory.getReceiptMapper());
        } catch (Exception e) {
            logger.error(Logs.ReceiptService.FIND_ALL_FAILED, e);
            throw new AppException(Logs.ReceiptService.FIND_ALL_FAILED, e);
        }

        return receiptList;
    }

    public List<Receipt> findAllByUser(Long userId) {
        List<Receipt> receiptList;

        try {
            receiptList = jdbcDao.getObjects(Query.Receipt.SELECT_ALL_BY_USER, EntityMapperFactory.getReceiptMapper(), userId);
        } catch (Exception e) {
            logger.error(Logs.ReceiptService.FIND_ALL_BY_USER_FAILED, e);
            throw new AppException(Logs.ReceiptService.FIND_ALL_BY_USER_FAILED, e);
        }

        return receiptList;
    }

}

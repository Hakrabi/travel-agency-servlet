package com.example.travel_agency.model.entity.mapper;

import com.example.travel_agency.controller.dto.ReceiptDto;
import com.example.travel_agency.model.constant.Logs;
import com.example.travel_agency.model.entity.Receipt;
import com.example.travel_agency.model.exception.AppException;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptMapper implements IEntityMapper<Receipt, ReceiptDto> {

    private static Logger logger = Logger.getLogger(ReceiptMapper.class);

    @Override
    public Receipt map(ResultSet rs) throws AppException {
        Receipt receipt = new Receipt();


        try {
            receipt.setId(rs.getLong("id"));
            receipt.setReceiptStatusId(rs.getLong("receipt_status_id"));
            receipt.setUserId(rs.getLong("user_id"));
            receipt.setTourId(rs.getLong("tour_id"));
            receipt.setCreateTime(rs.getTimestamp("create_time"));
        }  catch (SQLException e) {
            logger.error(Logs.Mapper.RECEIPT_MAPPER_FAILED, e);
            throw new AppException(Logs.Mapper.RECEIPT_MAPPER_FAILED, e);
        }

        return receipt;
    }

    @Override
    public Receipt map(ReceiptDto receiptDto){
        Receipt receipt = new Receipt();

        Long userId = receiptDto.getUserId();
        Long tourId = Long.valueOf(receiptDto.getTourId());

        receipt.setUserId(userId);
        receipt.setTourId(tourId);

        return receipt;
    }
}

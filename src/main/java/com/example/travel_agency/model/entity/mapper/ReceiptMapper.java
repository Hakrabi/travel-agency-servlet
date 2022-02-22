package com.example.travel_agency.model.entity.mapper;

import com.example.travel_agency.controller.dto.ReceiptDto;
import com.example.travel_agency.model.entity.Receipt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptMapper implements IEntityMapper<Receipt, ReceiptDto> {
    @Override
    public Receipt map(ResultSet rs) throws SQLException {
        Receipt receipt = new Receipt();

        receipt.setId(rs.getLong("id"));
        receipt.setReceiptStatusId(rs.getLong("receipt_status_id"));
        receipt.setUserId(rs.getLong("user_id"));
        receipt.setTourId(rs.getLong("tour_id"));
        receipt.setCreateTime(rs.getTimestamp("create_time"));

        return receipt;
    }

    @Override
    public Receipt map(ReceiptDto receiptDto) throws SQLException {
        Receipt receipt = new Receipt();

        Long userId = receiptDto.getUserId();
        Long tourId = Long.valueOf(receiptDto.getTourId());

        receipt.setUserId(userId);
        receipt.setTourId(tourId);

        return receipt;
    }
}

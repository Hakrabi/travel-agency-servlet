package com.example.travel_agency.model.entity.builder;

import com.example.travel_agency.model.entity.Receipt;
import com.example.travel_agency.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptBuilder implements IEntityBuilder<Receipt>{
    @Override
    public Receipt build(ResultSet rs) throws SQLException {
        Receipt receipt = new Receipt();

        receipt.setId(rs.getLong("id"));
        receipt.setReceiptStatusId(rs.getLong("receipt_status_id"));
        receipt.setUserId(rs.getLong("user_id"));
        receipt.setTourId(rs.getLong("tour_id"));
        receipt.setCreateTime(rs.getTimestamp("create_time"));

        return receipt;
    }

    @Override
    public Receipt build(HttpServletRequest req) throws SQLException {

        User user = (User) req.getSession().getAttribute("user");

        Long userId = user.getId();
        Long tourId = Long.valueOf(req.getParameter("tourId"));
        System.out.println(tourId);

        Receipt receipt = new Receipt();
        receipt.setUserId(userId);
        receipt.setTourId(tourId);

        return receipt;
    }
}

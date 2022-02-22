package com.example.travel_agency.controller.dto;

import com.example.travel_agency.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class ReceiptDto implements IDto{
    private Long userId;
    private String tourId;

    public ReceiptDto(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");

        userId = user.getId();
        tourId = request.getParameter("tourId");
    }

    public Long getUserId() {
        return userId;
    }

    public String getTourId() {
        return tourId;
    }
}

package com.example.travel_agency.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Receipt extends Entity{
    private Long receiptStatusId;
    private Long tourId;
    private Long userId;
    private Timestamp createTime;
    private BigDecimal price;
    private BigDecimal discount;

    public Long getReceiptStatusId() {
        return receiptStatusId;
    }

    public void setReceiptStatusId(Long receiptStatusId) {
        this.receiptStatusId = receiptStatusId;
    }

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}

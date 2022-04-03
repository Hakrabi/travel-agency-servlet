package com.example.travel_agency.model.service;

import com.example.travel_agency.model.entity.Receipt;
import com.example.travel_agency.model.exception.AppException;

public interface IReceiptService extends IEntityService<Receipt, Long> {
    void changeReceiptStatus(Long tourId, Long statusId) throws AppException;

}

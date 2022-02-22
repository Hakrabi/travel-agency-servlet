package com.example.travel_agency.model.service;

import com.example.travel_agency.model.entity.Receipt;

public interface IReceiptService extends IEntityService<Receipt, Long> {
    void changeReceiptStatus(Long tourId, Long statusId);

}

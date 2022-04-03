package com.example.travel_agency.controller.command.post.manager;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constant.Path;
import com.example.travel_agency.model.exception.AppException;
import com.example.travel_agency.model.service.impl.ReceiptService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditReceiptStatusCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        String receiptIdParam = request.getParameter("receiptId");
        String statusIdParam = request.getParameter("statusId");

        Long receiptId = Long.valueOf(receiptIdParam);
        Long statusId = Long.valueOf(statusIdParam);

        ReceiptService receiptService = new ReceiptService();
        receiptService.changeReceiptStatus(receiptId, statusId);

        return Path.REDIRECT + Path.RECEIPT_LIST;
    }
}

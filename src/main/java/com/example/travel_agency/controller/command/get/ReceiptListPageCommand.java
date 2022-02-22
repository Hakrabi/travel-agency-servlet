package com.example.travel_agency.controller.command.get;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.model.entity.Receipt;
import com.example.travel_agency.model.service.impl.ReceiptService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ReceiptListPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ReceiptService receiptService = new ReceiptService();

        List<Receipt> receiptList = receiptService.findAll();
        request.setAttribute("receiptList", receiptList);

        return Path.PAGE_RECEIPT_LIST;
    }
}

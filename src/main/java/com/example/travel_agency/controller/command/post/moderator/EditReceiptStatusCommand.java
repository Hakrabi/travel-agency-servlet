package com.example.travel_agency.controller.command.post.moderator;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.model.entity.Receipt;
import com.example.travel_agency.model.service.impl.ReceiptService;
import com.example.travel_agency.model.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditReceiptStatusCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String tourIdParam = request.getParameter("tourId");
        String statusIdParam = request.getParameter("statusId");

        Long tourId = Long.valueOf(tourIdParam);
        Long statusId = Long.valueOf(statusIdParam);

        ReceiptService receiptService = new ReceiptService();
        receiptService.changeReceiptStatus(tourId, statusId);

        return Path.REDIRECT + Path.RECEIPT_LIST;
    }
}

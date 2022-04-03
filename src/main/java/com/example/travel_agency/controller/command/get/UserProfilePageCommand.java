package com.example.travel_agency.controller.command.get;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constant.Path;
import com.example.travel_agency.model.entity.Receipt;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.exception.AppException;
import com.example.travel_agency.model.service.impl.ReceiptService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserProfilePageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null)
            return Path.REDIRECT + Path.HOME;

        Long userId = user.getId();

        ReceiptService receiptService = new ReceiptService();
        List<Receipt> userReceiptList = receiptService.findAllByUser(userId);
        request.setAttribute("userReceiptList", userReceiptList);

        return Path.PAGE_USER_PROFILE;
    }
}

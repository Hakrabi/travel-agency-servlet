package com.example.travel_agency.controller.command.post.common;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.controller.dto.ReceiptDto;
import com.example.travel_agency.model.constant.Path;
import com.example.travel_agency.model.entity.Receipt;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.entity.mapper.EntityMapperFactory;
import com.example.travel_agency.model.exception.AppException;
import com.example.travel_agency.model.service.impl.ReceiptService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddReceiptCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return Path.REDIRECT + Path.HOME;
        }

        ReceiptDto receiptDto = new ReceiptDto(request);
        Receipt receipt = EntityMapperFactory.getReceiptMapper().map(receiptDto);

        ReceiptService receiptService = new ReceiptService();
        Long id = receiptService.create(receipt);

        return Path.REDIRECT + Path.USER_PROFILE;

    }
}

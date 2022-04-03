package com.example.travel_agency.controller.command.post.admin;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constant.Path;
import com.example.travel_agency.model.exception.AppException;
import com.example.travel_agency.model.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlockUserCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {

        String idParam = request.getParameter("id");
        String blockParam = request.getParameter("block");

        Long id = Long.valueOf(idParam);
        Boolean block = Boolean.valueOf(blockParam);

        UserService userService = new UserService();
        userService.changeUserBlock(id, block);

        return Path.REDIRECT + Path.USER_LIST;
    }
}

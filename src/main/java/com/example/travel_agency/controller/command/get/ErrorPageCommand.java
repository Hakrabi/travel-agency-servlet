package com.example.travel_agency.controller.command.get;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constant.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Path.PAGE_ERROR_PAGE;
    }
}

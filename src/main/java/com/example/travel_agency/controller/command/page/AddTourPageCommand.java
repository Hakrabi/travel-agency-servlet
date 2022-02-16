package com.example.travel_agency.controller.command.page;

import com.example.travel_agency.controller.Path;
import com.example.travel_agency.controller.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTourPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        return Path.PAGE_ADD_TOUR;
    }
}

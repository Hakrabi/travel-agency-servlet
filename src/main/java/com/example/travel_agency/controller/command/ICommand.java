package com.example.travel_agency.controller.command;

import com.example.travel_agency.model.exception.AppException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {

  String execute(HttpServletRequest request, HttpServletResponse response) throws AppException;
}

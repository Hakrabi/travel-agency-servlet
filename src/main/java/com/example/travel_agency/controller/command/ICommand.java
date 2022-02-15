package com.example.travel_agency.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface ICommand {

  String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException;
}

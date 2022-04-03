package com.example.travel_agency.controller;

import com.example.travel_agency.controller.command.CommandFactory;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constant.Path;
import com.example.travel_agency.model.exception.AppException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.getSession().removeAttribute("error");
        request.setAttribute("origRequestURL", request.getRequestURL());

        CommandFactory commandFactory = CommandFactory.commandFactory();
        ICommand command = commandFactory.getCommand(request);

        String page;
        try {
            page = command.execute(request, response);
        } catch (AppException e) {
            page = Path.REDIRECT + Path.ERROR_PAGE;
            request.getSession().setAttribute("error", e.getMessage());
        } catch (Exception e) {
            page = Path.REDIRECT + Path.ERROR_PAGE;
            request.getSession().setAttribute("error", "Something wrong");
        }

        if (page.startsWith(Path.REDIRECT)) {
            response.sendRedirect(page.replaceAll(Path.REDIRECT, ""));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}

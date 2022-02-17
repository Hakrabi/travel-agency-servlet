package com.example.travel_agency.controller;

import com.example.travel_agency.controller.command.CommandFactory;
import com.example.travel_agency.controller.command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet("/")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CommandFactory commandFactory = CommandFactory.commandFactory();
        ICommand command = commandFactory.getCommand(req);

        String page = null;
        try {
            page = command.execute(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        String path = req.getRequestURI();
//        path = req.getMethod() + ':' + path;
//        Command command = commands.getOrDefault(path, (r) -> Pages.ERROR_404_PAGE);
//        return command.execute(req);

        req.setAttribute("origRequestURL", req.getRequestURL());

        if (page.startsWith(Path.REDIRECT)) {
            resp.sendRedirect(page.replaceAll(Path.REDIRECT, ""));
        } else {
            req.getRequestDispatcher(page).forward(req, resp);
        }
    }
}

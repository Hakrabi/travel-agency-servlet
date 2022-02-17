package com.example.travel_agency.controller.command.page;

import com.example.travel_agency.model.constants.Path;
import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.database.dao.ITourDao;
import com.example.travel_agency.model.database.dao.factory.IDaoFactory;
import com.example.travel_agency.model.database.dao.factory.JdbcDaoFactory;
import com.example.travel_agency.model.entity.Tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ToursMainPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        IDaoFactory factory = new JdbcDaoFactory();
        ITourDao tourDao = factory.getTourDao();

        String paramPage = request.getParameter("page");
        int page = 1;
        if (!(paramPage == null))
            page = Integer.parseInt(paramPage);

        int pageSize = 6;

        List<Tour> tourList = tourDao.findAllByPage(pageSize * (page - 1), pageSize);
        int size = tourDao.getSize();

        int shift = 0;
        int pageCount = (int)Math.ceil(size / pageSize);

        request.setAttribute("tourList", tourList);
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("page", page);

        return Path.PAGE_TOURS;
    }
}

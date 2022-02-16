package com.example.travel_agency.controller.command.page;

import com.example.travel_agency.controller.Path;
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

        int limit = 6;

        List<Tour> tourList = tourDao.findAllByPage(page, limit);
        int size = tourDao.getSize();

        int shift = 0;
        int minPagePossible = page - shift < 1 ? 1 : page - shift;

        int pageCount = (int)Math.ceil(size / limit);
        int maxPagePossible = page + shift > pageCount ? pageCount : page + shift;

        request.setAttribute("tourList", tourList);
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("page", page);
//        request.setAttribute("pageSize", pageSize);
        request.setAttribute("minPossiblePage", minPagePossible);
        request.setAttribute("maxPossiblePage", maxPagePossible);

        return Path.PAGE_TOURS;
    }
}

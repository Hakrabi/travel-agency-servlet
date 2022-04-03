package com.example.travel_agency.controller.command.get;

import com.example.travel_agency.controller.command.ICommand;
import com.example.travel_agency.model.constant.Path;
import com.example.travel_agency.model.entity.Tour;
import com.example.travel_agency.model.service.impl.TourService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ToursMainPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TourService tourService = new TourService();

        String paramSort  = request.getParameter("sort");
        String paramOrder = request.getParameter("order");
        String paramType  = request.getParameter("type");


        String paramPage = request.getParameter("page");
        int page = 1;
        if (!(paramPage == null))
            page = Integer.parseInt(paramPage);

        int pageSize = 6;

        List<Tour> tourList = tourService.findAllByPageSort(pageSize * (page - 1), pageSize,
                                                                  paramSort, paramOrder, paramType);

        int size = tourService.getSizeSort(paramType);
        int shift = 0;
        int pageCount = (int)Math.ceil(size / pageSize);

        request.setAttribute("tourList", tourList);
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("page", page);

        return Path.PAGE_TOURS;
    }
}

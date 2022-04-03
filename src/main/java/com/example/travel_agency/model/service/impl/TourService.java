package com.example.travel_agency.model.service.impl;

import com.example.travel_agency.model.constant.Logs;
import com.example.travel_agency.model.database.Query;
import com.example.travel_agency.model.database.dao.jdbcDao;
import com.example.travel_agency.model.entity.Tour;
import com.example.travel_agency.model.entity.mapper.EntityMapperFactory;
import com.example.travel_agency.model.exception.AppException;
import com.example.travel_agency.model.service.ITourService;
import org.apache.log4j.Logger;

import java.util.List;

public class TourService implements ITourService {

    private static Logger logger = Logger.getLogger(TourService.class);


    @Override
    public Long create(Tour tour)  throws AppException {
        Long id;

        try {
            id = jdbcDao.insert(Query.Tour.INSERT,
                    tour.getName(),
                    tour.getDescription(),
                    tour.getPrice(),
                    tour.getPersons(),
                    tour.getTourTypeId(),
                    tour.getHotelTypeId(),
                    tour.getHot(),
                    tour.getImgUrl(),
                    tour.getDiscountLimit(),
                    tour.getDiscountStep());

            logger.info(Logs.TourService.CREATE_SUCCESS + id);

        } catch (Exception e) {
            logger.error(Logs.TourService.CREATE_FAILED, e);
            throw new AppException(Logs.TourService.CREATE_FAILED, e);
        }

        return id;
    }

    @Override
    public Tour read(Long id) throws AppException {
        Tour tour;
        try {
            tour = jdbcDao.getObject(Query.Tour.SELECT_BY_ID, EntityMapperFactory.getTourMapper(), id);
        } catch (Exception e) {
            logger.error(Logs.TourService.READ_FAILED, e);
            throw new AppException(Logs.TourService.READ_FAILED, e);
        }

        return tour;
    }

    @Override
    public void update(Tour tour) throws AppException {
        try {
            jdbcDao.insert(Query.Tour.UPDATE,
                    tour.getName(),
                    tour.getDescription(),
                    tour.getPrice(),
                    tour.getPersons(),
                    tour.getTourTypeId(),
                    tour.getHotelTypeId(),
                    tour.getHot(),
                    tour.getImgUrl(),
                    tour.getDiscountLimit(),
                    tour.getDiscountStep(),
                    tour.getId());

            logger.info(Logs.TourService.UPDATE_SUCCESS + tour.getId());

        }catch (Exception e) {
            logger.error(Logs.TourService.UPDATE_FAILED, e);
            throw new AppException(Logs.TourService.UPDATE_FAILED, e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            jdbcDao.delete(Query.Tour.DELETE, id);

            logger.info(Logs.TourService.DELETE_SUCCESS + id);

        } catch (Exception e) {
            logger.error(Logs.TourService.DELETE_FAILED, e);
            throw new AppException(Logs.TourService.DELETE_FAILED, e);
        }
    }

    @Override
    public List<Tour> findAll() throws AppException {
        List<Tour> tourList;

        try {
            tourList = jdbcDao.getObjects(Query.Tour.SELECT_ALL, EntityMapperFactory.getTourMapper());
        }catch (Exception e) {
            logger.error(Logs.TourService.FIND_ALL_FAILED, e);
            throw new AppException(Logs.TourService.FIND_ALL_FAILED, e);
        }

        return tourList;
    }

    @Override
    public List<Tour> findAllByPageSort(Integer page, Integer limit, String sort, String order, String tourType) throws AppException {
        List<Tour> tourList = null;

        try {
            String orderQuery = Query.Tour.Order.getOrderQuery(tourType, sort, order);
            tourList = jdbcDao.getObjects(orderQuery, EntityMapperFactory.getTourMapper(), limit,  page);
        }catch (Exception e) {
            logger.error(Logs.TourService.FIND_ALL_SORT_FAILED, e);
            throw new AppException(Logs.TourService.FIND_ALL_SORT_FAILED, e);
        }

        return tourList;
    }

    @Override
    public Integer getSizeSort(String tourType) throws AppException {
        Integer size = 0;
        try {
            String orderSizeQuery = Query.Tour.Order.getOrderTypeSizeQuery(tourType);
            size = jdbcDao.getSize(orderSizeQuery);
        }catch (Exception e) {
            logger.error(Logs.TourService.GET_SIZE_SORT, e);
            throw new AppException(Logs.TourService.GET_SIZE_SORT, e);
        }

        return size;
    }

}

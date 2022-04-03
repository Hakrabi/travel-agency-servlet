package com.example.travel_agency.model.service.impl;

import com.example.travel_agency.model.constant.Logs;
import com.example.travel_agency.model.database.Query;
import com.example.travel_agency.model.database.dao.jdbcDao;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.entity.mapper.EntityMapperFactory;
import com.example.travel_agency.model.exception.AppException;
import com.example.travel_agency.model.service.IUserService;
import org.apache.log4j.Logger;

import java.util.List;

public class UserService implements IUserService {

    private static Logger logger = Logger.getLogger(UserService.class);

    @Override
    public Long create(User user) throws AppException{
        Long id;

        try {
            id = jdbcDao.insert(Query.User.INSERT,
                    user.getUserRoleId(),
                    user.getLogin(),
                    user.getPassword(),
                    user.getName());

            logger.info(Logs.UserService.CREATE_SUCCESS + id);

        }  catch (Exception e) {
            logger.error(Logs.UserService.CREATE_FAILED, e);
            throw new AppException(Logs.UserService.CREATE_FAILED, e);
        }

        return id;
    }

    @Override
    public User read(Long id) throws AppException{
        User user;
        try {
            user = jdbcDao.getObject(Query.User.SELECT_BY_ID, EntityMapperFactory.getUserMapper(), id);
        }  catch (Exception e) {
            logger.error(Logs.UserService.READ_FAILED, e);
            throw new AppException(Logs.UserService.READ_FAILED, e);
        }

        return user;
    }

    @Override
    public User read(String login) throws AppException{
        User user;
        try {
            user = jdbcDao.getObject(Query.User.SELECT_BY_LOGIN, EntityMapperFactory.getUserMapper(), login);
        } catch (Exception e) {
            logger.error(Logs.UserService.READ_FAILED, e);
            throw new AppException(Logs.UserService.READ_FAILED, e);
        }

        return user;
    }

    @Override
    public void changeUserBlock(Long id, Boolean block) throws AppException{
        try {
            User user = read(id);
            if (user.getUserRoleId() != 1){
                jdbcDao.update(Query.User.UPDATE_BLOCK, block, id);
                logger.info(Logs.UserService.CHANGE_USER_BLOCK_SUCCESS + id);
            }
        } catch (Exception e) {
            logger.error(Logs.UserService.CHANGE_USER_BLOCK_FAILED, e);
            throw new AppException(Logs.UserService.CHANGE_USER_BLOCK_FAILED, e);
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Long id) {

    }


    @Override
    public List<User> findAll() {
        List<User> userList;
        try {
            userList = jdbcDao.getObjects(Query.User.SELECT_ALL, EntityMapperFactory.getUserMapper());
        }catch (Exception e) {
            logger.error(Logs.UserService.FIND_ALL_FAILED, e);
            throw new AppException(Logs.UserService.FIND_ALL_FAILED, e);
        }

        return userList;
    }

}

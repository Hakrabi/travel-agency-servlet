package com.example.travel_agency.model.service.impl;

import com.example.travel_agency.model.database.Queries;
import com.example.travel_agency.model.database.dao.jdbcDao;
import com.example.travel_agency.model.service.IUserService;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.entity.mapper.EntityMapperFactory;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {

    @Override
    public Long create(User user) {
        Long id = null;

        id = jdbcDao.insert(Queries.User.INSERT,
                user.getUserRoleId(),
                user.getLogin(),
                user.getPassword(),
                user.getName());

        return id;
    }

    @Override
    public User read(Long id) {
        User user = null;
        try {
            user = jdbcDao.getObject(Queries.User.SELECT_BY_ID, EntityMapperFactory.getUserMapper(), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    @Override
    public User read(String login) {
        User user = null;
        try {
            user = jdbcDao.getObject(Queries.User.SELECT_BY_LOGIN, EntityMapperFactory.getUserMapper(), login);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    @Override
    public void changeUserBlock(Long id, Boolean block) {
        User user = read(id);
        if (user.getUserRoleId() != 1){
            jdbcDao.update(Queries.User.UPDATE_BLOCK, block, id);
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

        List<User> userList = null;
        try {
            userList = jdbcDao.getObjects(Queries.User.SELECT_ALL, EntityMapperFactory.getUserMapper());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userList;
    }

    @Override
    public List<User> findAllByPage(Integer page, Integer limit) {
        return null;
    }

    @Override
    public Integer getSize() {
        return null;
    }
}

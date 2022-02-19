package com.example.travel_agency.model.database.dao.jdbc;

import com.example.travel_agency.model.database.Queries;
import com.example.travel_agency.model.database.QueryExecutor;
import com.example.travel_agency.model.database.dao.IUserDao;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.entity.builder.EntityBuilderFactory;

import java.sql.SQLException;
import java.util.List;

public class UserDao implements IUserDao {

    @Override
    public Long create(User user) {
        Long id = null;

        id = QueryExecutor.insert(Queries.User.INSERT,
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
            user = QueryExecutor.getObject(Queries.User.SELECT_BY_ID, EntityBuilderFactory.getUserBuilder(), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    @Override
    public User read(String login) {
        User user = null;
        try {
            user = QueryExecutor.getObject(Queries.User.SELECT_BY_LOGIN, EntityBuilderFactory.getUserBuilder(), login);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    @Override
    public void changeUserBlock(Long id, Boolean block) {
        User user = read(id);
        if (user.getUserRoleId() != 1){
            QueryExecutor.update(Queries.User.CHANGE_BLOCK, block, id);
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
            userList = QueryExecutor.getObjects(Queries.User.SELECT_ALL, EntityBuilderFactory.getUserBuilder());
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

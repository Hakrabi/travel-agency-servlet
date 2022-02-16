package com.example.travel_agency.model.database.dao;

import com.example.travel_agency.model.entity.User;

public interface IUserDao extends IDao<User, Long>{

    public User read(String login);

}

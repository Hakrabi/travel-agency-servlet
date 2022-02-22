package com.example.travel_agency.model.service;

import com.example.travel_agency.model.entity.User;

public interface IUserService extends IEntityService<User, Long> {

    public User read(String login);
    public void changeUserBlock(Long id, Boolean block);

}

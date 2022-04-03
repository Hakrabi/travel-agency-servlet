package com.example.travel_agency.model.service;

import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.exception.AppException;

public interface IUserService extends IEntityService<User, Long> {
    User read(String login) throws AppException;
    void changeUserBlock(Long id, Boolean block) throws AppException;
}

package com.example.travel_agency.model.entity.mapper;

import com.example.travel_agency.controller.dto.UserDto;
import com.example.travel_agency.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements IEntityMapper<User, UserDto> {
    @Override
    public User map(ResultSet rs) throws SQLException {
        User user = new User();

        user.setId(rs.getLong("id"));
        user.setUserRoleId(rs.getShort("user_role_id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setBlocked(rs.getBoolean("block"));
        user.setCreateTime(rs.getTimestamp("create_time"));

        return user;
    }

    @Override
    public User map(UserDto userDto) throws SQLException {
        User user = new User();

        String login    = userDto.getLogin();
        String password = userDto.getPassword();
        String name     = userDto.getName();

        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);

        return user;
    }
}

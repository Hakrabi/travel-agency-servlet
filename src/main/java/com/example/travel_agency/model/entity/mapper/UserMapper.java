package com.example.travel_agency.model.entity.mapper;

import com.example.travel_agency.controller.dto.UserDto;
import com.example.travel_agency.model.constant.Logs;
import com.example.travel_agency.model.entity.User;
import com.example.travel_agency.model.exception.AppException;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements IEntityMapper<User, UserDto> {

    private static Logger logger = Logger.getLogger(UserMapper.class);

    @Override
    public User map(ResultSet rs) throws AppException {
        User user = new User();

        try {
            user.setId(rs.getLong("id"));
            user.setUserRoleId(rs.getShort("user_role_id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setBlocked(rs.getBoolean("block"));
            user.setCreateTime(rs.getTimestamp("create_time"));
        }  catch (SQLException e) {
            logger.error(Logs.Mapper.USER_MAPPER_FAILED, e);
            throw new AppException(Logs.Mapper.USER_MAPPER_FAILED, e);
        }


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

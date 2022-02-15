package com.example.travel_agency.model.entity.builder;

import com.example.travel_agency.model.entity.Entity;
import com.example.travel_agency.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserBuilder implements IEntityBuilder<User>{
    @Override
    public User build(ResultSet rs) throws SQLException {
        User user = new User();

        user.setId(rs.getLong("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setCreate_time(rs.getDate("create_time"));
        user.setUser_role_id(rs.getShort("user_role_id"));

        return user;
    }
}

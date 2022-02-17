package com.example.travel_agency.model.entity.builder;

import com.example.travel_agency.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements IEntityBuilder<User>{
    @Override
    public User build(ResultSet rs) throws SQLException {
        User user = new User();

        user.setId(rs.getLong("id"));
        user.setUserRoleId(rs.getShort("user_role_id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setBlocked(rs.getBoolean("block"));
        user.setCreateTime(rs.getDate("create_time"));

        return user;
    }

    @Override
    public User build(HttpServletRequest req) throws SQLException {
        User user = new User();

        String login    = req.getParameter("login");
        String password = req.getParameter("password");
        String name     = req.getParameter("name");

        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);

        return user;
    }
}

package com.example.travel_agency.model.entity;

import java.util.Date;

public class User extends Entity{
    private String login;
    private String password;
    private String name;
    private Date create_time;
    private Short user_role_id;

    public User(){}



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Short getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Short user_role_id) {
        this.user_role_id = user_role_id;
    }
}

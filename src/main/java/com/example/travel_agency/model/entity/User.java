package com.example.travel_agency.model.entity;

import java.sql.Timestamp;

public class User extends Entity{
    private String login;
    private String password;
    private String name;
    private Timestamp createTime;
    private Short userRoleId;
    private Boolean blocked;

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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Short getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Short userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", create_time=" + createTime +
                ", user_role_id=" + userRoleId +
                '}';
    }


}

package com.example.travel_agency.model.entity;

public enum Role {
    ADMIN(1),
    MODERATOR(2),
    CLIENT(3);

    Long id;

    Role(long id) {
        this.id = id;
    }
}

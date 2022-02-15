package com.example.travel_agency.model.database;

public class Queries{
    public static class User {
        public static final String INSERT       = "INSERT INTO user (login) VALUES(?)";
        public static final String SELECT_ALL   = "SELECT * FROM user";
        public static final String DELETE       = "DELETE FROM users WHERE login = ?";
        public static final String SELECT_ONE   = "SELECT * FROM users WHERE login = ?";
    }

    public static class Tour {
        public static final String INSERT       = "INSERT INTO teams (name) VALUES(?)";
        public static final String SELECT_ALL   = "SELECT * FROM tour ORDER BY hot DESC";
        public static final String SELECT_BY_ID = "SELECT * FROM tour WHERE id = ?";
        public static final String DELETE       = "DELETE FROM teams WHERE name = ?";
        public static final String SELECT_ONE   = "SELECT * FROM teams WHERE name = ?";
        public static final String UPDATE       = "UPDATE teams SET name = ? WHERE id = ?";
    }

    public static class Receipt {
        public static final String INSERT       = "INSERT INTO teams (name) VALUES(?)";
        public static final String SELECT_ALL   = "SELECT * FROM teams";
        public static final String DELETE       = "DELETE FROM teams WHERE name = ?";
        public static final String SELECT_ONE   = "SELECT * FROM teams WHERE name = ?";
        public static final String UPDATE       = "UPDATE teams SET name = ? WHERE id = ?";
    }

    public static class Team {
        public static final String INSERT       = "INSERT INTO teams (name) VALUES(?)";
        public static final String SELECT_ALL   = "SELECT * FROM teams";
        public static final String DELETE       = "DELETE FROM teams WHERE name = ?";
        public static final String SELECT_ONE   = "SELECT * FROM teams WHERE name = ?";
        public static final String UPDATE       = "UPDATE teams SET name = ? WHERE id = ?";
    }

    public static class UsersTeams {
        public static final String INSERT       = "INSERT INTO users_teams VALUES(" +
                "(SELECT id FROM users WHERE login = ?), " +
                "(SELECT id FROM teams WHERE name = ?))";
        public static final String SELECT_USER_TEAMS
                = "SELECT * " +
                  "FROM teams " +
                  "INNER JOIN users_teams ON users_teams.team_id = teams.id " +
                  "WHERE users_teams.user_id = ?";
    }
}


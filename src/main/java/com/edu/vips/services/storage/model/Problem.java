package com.edu.vips.services.storage.model;

import com.edu.vips.dao.entities.UserEntity;

import java.util.Set;

public class Problem {
    private long id;

    private String name;

    private String statement;

    private long timeLimitInMillis;

    private Set<UserEntity> usersSolvedProblem;

    private Set<UserEntity> usersBookmarkedProblem;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public long getTimeLimitInMillis() {
        return timeLimitInMillis;
    }

    public void setTimeLimitInMillis(long timeLimitInMillis) {
        this.timeLimitInMillis = timeLimitInMillis;
    }

    public Set<UserEntity> getUsersSolvedProblem() {
        return usersSolvedProblem;
    }

    public void setUsersSolvedProblem(Set<UserEntity> usersSolvedProblem) {
        this.usersSolvedProblem = usersSolvedProblem;
    }

    public Set<UserEntity> getUsersBookmarkedProblem() {
        return usersBookmarkedProblem;
    }

    public void setUsersBookmarkedProblem(Set<UserEntity> usersBookmarkedProblem) {
        this.usersBookmarkedProblem = usersBookmarkedProblem;
    }
}

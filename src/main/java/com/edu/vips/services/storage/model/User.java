package com.edu.vips.services.storage.model;

import com.edu.vips.dao.entities.ProblemEntity;

import java.util.Set;

public class User {
    private long id;

    private String userName;

    private String password;

    private String email;

    private Set<ProblemEntity> solvedProblem;

    private Set<ProblemEntity> bookmarkedProblem;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ProblemEntity> getSolvedProblem() {
        return solvedProblem;
    }

    public void setSolvedProblem(Set<ProblemEntity> solvedProblem) {
        this.solvedProblem = solvedProblem;
    }

    public Set<ProblemEntity> getBookmarkedProblem() {
        return bookmarkedProblem;
    }

    public void setBookmarkedProblem(Set<ProblemEntity> bookmarkedProblem) {
        this.bookmarkedProblem = bookmarkedProblem;
    }
}

package com.edu.vips.dao.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;

    private String password;

    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProblemEntity> solvedProblems;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProblemEntity> bookmarkedProblems;

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

    public Set<ProblemEntity> getSolvedProblems() {
        return solvedProblems;
    }

    public void setSolvedProblems(Set<ProblemEntity> solvedProblems) {
        this.solvedProblems = solvedProblems;
    }

    public Set<ProblemEntity> getBookmarkedProblems() {
        return bookmarkedProblems;
    }

    public void setBookmarkedProblems(Set<ProblemEntity> bookmarkedProblems) {
        this.bookmarkedProblems = bookmarkedProblems;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

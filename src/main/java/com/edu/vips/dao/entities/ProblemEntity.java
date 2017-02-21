package com.edu.vips.dao.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProblemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Lob
    private String statement;

    private long timeLimitInMillis;

    @ManyToMany(mappedBy = "solvedProblems", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserEntity> usersSolvedProblem;

    @ManyToMany(mappedBy = "bookmarkedProblems", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

    @Override
    public String toString() {
        return "ProblemEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", statement='" + statement + '\'' +
                ", timeLimitInMillis=" + timeLimitInMillis +
                '}';
    }
}

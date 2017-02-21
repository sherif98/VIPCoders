package com.edu.vips.services.submission.model;

public class Submission {

    private long userId;
    private long problemId;
    private ProgrammingLanguage programmingLanguage;
    private String code;


    public Submission(long userId, long problemId, ProgrammingLanguage programmingLanguage, String code) {
        this.userId = userId;
        this.problemId = problemId;
        this.programmingLanguage = programmingLanguage;
        this.code = code;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProblemId() {
        return problemId;
    }

    public void setProblemId(long problemId) {
        this.problemId = problemId;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

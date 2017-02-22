package com.edu.vips.services.submission.model;

public class Submission {

    private long userId;
    private long problemId;
    private ProgrammingLanguage programmingLanguage;
    private String sourceCode;


    public Submission(long userId, long problemId, ProgrammingLanguage programmingLanguage, String sourceCode) {
        this.userId = userId;
        this.problemId = problemId;
        this.programmingLanguage = programmingLanguage;
        this.sourceCode = sourceCode;
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

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Override
    public String toString() {
        return "Submission{" +
                "userId=" + userId +
                ", problemId=" + problemId +
                ", programmingLanguage=" + programmingLanguage +
                ", sourceCode='" + sourceCode + '\'' +
                '}';
    }
}

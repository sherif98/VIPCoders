package com.edu.vips.services.submission.impl.runner.model;

import com.edu.vips.services.submission.model.ProgrammingLanguage;

public class RunnerInput {

    private ProgrammingLanguage programmingLanguage;
    private String objectFileName;
    private long problemId;


    public RunnerInput(ProgrammingLanguage programmingLanguage, String objectFileName, long problemId) {
        this.programmingLanguage = programmingLanguage;
        this.objectFileName = objectFileName;
        this.problemId = problemId;
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

    public String getObjectFileName() {
        return objectFileName;
    }

    public void setObjectFileName(String objectFileName) {
        this.objectFileName = objectFileName;
    }

    @Override
    public String toString() {
        return "RunnerInput{" +
                "programmingLanguage=" + programmingLanguage +
                ", objectFileName='" + objectFileName + '\'' +
                ", problemId=" + problemId +
                '}';
    }
}

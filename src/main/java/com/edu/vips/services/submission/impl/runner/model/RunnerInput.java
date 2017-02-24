package com.edu.vips.services.submission.impl.runner.model;

import com.edu.vips.services.storage.model.Problem;
import com.edu.vips.services.submission.model.ProgrammingLanguage;

public class RunnerInput {

    private ProgrammingLanguage programmingLanguage;
    private String objectFileName;
    private Problem problem;


    public RunnerInput(ProgrammingLanguage programmingLanguage, String objectFileName, Problem problem) {
        this.programmingLanguage = programmingLanguage;
        this.objectFileName = objectFileName;
        this.problem = problem;
    }


    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }


    public String getObjectFileName() {
        return objectFileName;
    }


    public Problem getProblem() {
        return problem;
    }


    @Override
    public String toString() {
        return "RunnerInput{" +
                "programmingLanguage=" + programmingLanguage +
                ", objectFileName='" + objectFileName + '\'' +
                ", problemId=" + problem.getId() +
                '}';
    }
}

package com.edu.vips.services.submission.model;

public enum ProgrammingLanguage {
    JAVA(
            "javac", "java"
    ), SCALA(
            "", ""
    ), C(
            "", ""
    ), CPP(
            "", ""
    ), PYTHON(
            "", ""
    );


    ProgrammingLanguage(String compilationCommand, String executionCommand) {
        this.compilationCommand = compilationCommand;
        this.executionCommand = executionCommand;
    }

    private String compilationCommand;
    private String executionCommand;

    public String getCompilationCommand() {
        return compilationCommand;
    }

    public String getExecutionCommand() {
        return executionCommand;
    }
}

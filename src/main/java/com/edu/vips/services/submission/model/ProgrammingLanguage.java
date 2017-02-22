package com.edu.vips.services.submission.model;

public enum ProgrammingLanguage {
    JAVA(
            "javac", "java", ".java"
    ), SCALA(
            "", "", ".sc"
    ), C(
            "gcc", "", ".c"
    ), CPP(
            "", "", ".cpp"
    ), PYTHON(
            "", "", ".py"
    );


    ProgrammingLanguage(String compilationCommand, String executionCommand, String fileExtension) {
        this.compilationCommand = compilationCommand;
        this.executionCommand = executionCommand;
        this.fileExtension = fileExtension;
    }


    private String compilationCommand;
    private String executionCommand;
    private String fileExtension;

    public String getCompilationCommand() {
        return compilationCommand;
    }

    public String getExecutionCommand() {
        return executionCommand;
    }

    public String getFileExtension() {
        return fileExtension;
    }
}

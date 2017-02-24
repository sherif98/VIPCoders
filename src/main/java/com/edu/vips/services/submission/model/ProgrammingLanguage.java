package com.edu.vips.services.submission.model;

public enum ProgrammingLanguage {
    JAVA(
            "javac", "java", ".java", ".class"
    ), SCALA(
            "", "", ".sc", ".class"
    ), C(
            "gcc", "", ".c", ".exe"
    ), CPP(
            "", "", ".cpp", ".exe"
    ), PYTHON(
            "", "", ".py", ""
    );


    ProgrammingLanguage(String compilationCommand, String executionCommand, String sourceFileExtension, String binaryFileExtension) {
        this.compilationCommand = compilationCommand;
        this.executionCommand = executionCommand;
        this.sourceFileExtension = sourceFileExtension;
        this.binaryFileExtension = binaryFileExtension;
    }


    private String compilationCommand;
    private String executionCommand;
    private String sourceFileExtension;
    private String binaryFileExtension;

    public String getCompilationCommand() {
        return compilationCommand;
    }

    public String getExecutionCommand() {
        return executionCommand;
    }

    public String getSourceFileExtension() {
        return sourceFileExtension;
    }

    public String getBinaryFileExtension() {
        return binaryFileExtension;
    }
}

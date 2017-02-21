package com.edu.vips.services.submission.impl.compiler.model;

public class CompilationOutput {
    private CompilationStatus compilationStatus;
    private String objectFileName;

    public CompilationOutput(CompilationStatus compilationStatus, String objectFileName) {
        this.compilationStatus = compilationStatus;
        this.objectFileName = objectFileName;
    }

    public CompilationStatus getCompilationStatus() {
        return compilationStatus;
    }

    public void setCompilationStatus(CompilationStatus compilationStatus) {
        this.compilationStatus = compilationStatus;
    }

    public String getObjectFileName() {
        return objectFileName;
    }

    public void setObjectFileName(String objectFileName) {
        this.objectFileName = objectFileName;
    }

    @Override
    public String toString() {
        return "CompilationOutput{" +
                "compilationStatus=" + compilationStatus +
                ", objectFileName='" + objectFileName + '\'' +
                '}';
    }
}

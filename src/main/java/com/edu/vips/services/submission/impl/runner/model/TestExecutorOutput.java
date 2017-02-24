package com.edu.vips.services.submission.impl.runner.model;

public class TestExecutorOutput {
    private String output;
    private TestStatus runStatus;


    public String getOutput() {
        return output;
    }

    public TestStatus getRunStatus() {
        return runStatus;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public void setRunStatus(TestStatus runStatus) {
        this.runStatus = runStatus;
    }

    @Override
    public String toString() {
        return "TestExecutorOutput{" +
                "output='" + output + '\'' +
                ", runStatus=" + runStatus +
                '}';
    }
}

package com.edu.vips.services.submission.impl.runner.model;

public class RunnerOutput {

    private long testFailed;
    private RunStatus runStatus;


    public long getTestFailed() {
        return testFailed;
    }

    public void setTestFailed(long testFailed) {
        this.testFailed = testFailed;
    }

    public RunStatus getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(RunStatus runStatus) {
        this.runStatus = runStatus;
    }

    @Override
    public String toString() {
        return "RunnerOutput{" +
                "testFailed=" + testFailed +
                ", runStatus=" + runStatus +
                '}';
    }
}

package com.edu.vips.services.submission.impl.runner.model;

public class RunnerOutput {

    private long testFailed;
    private RunnerStatus runnerStatus;


    public RunnerOutput(long testFailed, RunnerStatus runnerStatus) {
        this.testFailed = testFailed;
        this.runnerStatus = runnerStatus;
    }

    public long getTestFailed() {
        return testFailed;
    }

    public void setTestFailed(long testFailed) {
        this.testFailed = testFailed;
    }

    public RunnerStatus getRunnerStatus() {
        return runnerStatus;
    }

    public void setRunnerStatus(RunnerStatus runnerStatus) {
        this.runnerStatus = runnerStatus;
    }

    @Override
    public String toString() {
        return "RunnerOutput{" +
                "testFailed=" + testFailed +
                ", runnerStatus=" + runnerStatus +
                '}';
    }
}

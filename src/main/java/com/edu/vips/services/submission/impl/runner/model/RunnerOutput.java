package com.edu.vips.services.submission.impl.runner.model;

public class RunnerOutput {

    private RunStatus runStatus;


    public RunStatus getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(RunStatus runStatus) {
        this.runStatus = runStatus;
    }

    @Override
    public String toString() {
        return "RunnerOutput{" +
                ", runStatus=" + runStatus +
                '}';
    }
}

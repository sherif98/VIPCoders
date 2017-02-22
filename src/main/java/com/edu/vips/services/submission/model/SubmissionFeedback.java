package com.edu.vips.services.submission.model;

public class SubmissionFeedback {
    private SubmissionFeedbackStatus submissionFeedbackStatus;
    private long testFailed;


    public SubmissionFeedbackStatus getSubmissionFeedbackStatus() {
        return submissionFeedbackStatus;
    }

    public void setSubmissionFeedbackStatus(SubmissionFeedbackStatus submissionFeedbackStatus) {
        this.submissionFeedbackStatus = submissionFeedbackStatus;
    }

    public long getTestFailed() {
        return testFailed;
    }

    public void setTestFailed(long testFailed) {
        this.testFailed = testFailed;
    }
}

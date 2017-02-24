package com.edu.vips.services.submission.model;

public class SubmissionFeedback {
    private SubmissionFeedbackStatus submissionFeedbackStatus;


    public SubmissionFeedbackStatus getSubmissionFeedbackStatus() {
        return submissionFeedbackStatus;
    }

    public void setSubmissionFeedbackStatus(SubmissionFeedbackStatus submissionFeedbackStatus) {
        this.submissionFeedbackStatus = submissionFeedbackStatus;
    }

    @Override
    public String toString() {
        return "SubmissionFeedback{" +
                "submissionFeedbackStatus=" + submissionFeedbackStatus +
                '}';
    }
}

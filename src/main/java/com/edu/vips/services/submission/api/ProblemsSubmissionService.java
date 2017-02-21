package com.edu.vips.services.submission.api;

import com.edu.vips.services.submission.model.Submission;
import com.edu.vips.services.submission.model.SubmissionFeedbackStatus;

public interface ProblemsSubmissionService {
    SubmissionFeedbackStatus submit(Submission submission);
}

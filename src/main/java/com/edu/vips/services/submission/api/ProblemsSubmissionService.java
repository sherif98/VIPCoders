package com.edu.vips.services.submission.api;

import com.edu.vips.services.submission.model.Submission;
import com.edu.vips.services.submission.model.SubmissionFeedback;

public interface ProblemsSubmissionService {
    SubmissionFeedback submit(Submission submission);
}

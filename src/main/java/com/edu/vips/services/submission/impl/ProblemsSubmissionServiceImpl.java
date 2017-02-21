package com.edu.vips.services.submission.impl;

import com.edu.vips.services.storage.api.ProblemStorageService;
import com.edu.vips.services.submission.api.ProblemsSubmissionService;
import com.edu.vips.services.submission.impl.compiler.api.CompilationService;
import com.edu.vips.services.submission.model.Submission;
import com.edu.vips.services.submission.model.SubmissionFeedbackStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class ProblemsSubmissionServiceImpl implements ProblemsSubmissionService {

    @Autowired
    private ProblemStorageService problemStorageService;

    @Autowired
    private CompilationService compilationService;

    @Override
    public SubmissionFeedbackStatus submit(Submission submission) {
        return null;
    }
}

package com.edu.vips.services.submission.impl;

import com.edu.vips.services.submission.api.ProblemsSubmissionService;
import com.edu.vips.services.submission.impl.compiler.api.CompilationService;
import com.edu.vips.services.submission.impl.compiler.model.CompilationOutput;
import com.edu.vips.services.submission.impl.compiler.model.CompilationStatus;
import com.edu.vips.services.submission.impl.compiler.model.CompilerInput;
import com.edu.vips.services.submission.impl.runner.api.TestRunnerService;
import com.edu.vips.services.submission.impl.runner.model.RunnerInput;
import com.edu.vips.services.submission.impl.runner.model.RunnerOutput;
import com.edu.vips.services.submission.model.ProgrammingLanguage;
import com.edu.vips.services.submission.model.Submission;
import com.edu.vips.services.submission.model.SubmissionFeedback;
import com.edu.vips.services.submission.model.SubmissionFeedbackStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemsSubmissionServiceImpl implements ProblemsSubmissionService {


    @Autowired
    private CompilationService compilationService;

    @Autowired
    private TestRunnerService testRunnerService;

    @Override
    public SubmissionFeedback submit(Submission submission) {
        CompilationOutput compilationOutput = compile(submission.getSourceCode(), submission.getProgrammingLanguage());
        if (isCompilationError(compilationOutput)) {
            SubmissionFeedback submissionFeedback = new SubmissionFeedback();
            submissionFeedback.setSubmissionFeedbackStatus(SubmissionFeedbackStatus.COMPILATION_ERROR);
            return submissionFeedback;
        }
        RunnerOutput runnerOutput = run(submission.getProgrammingLanguage(), compilationOutput.getObjectFileName(),
                submission.getProblemId());
        return getSubmissionFeedback(runnerOutput);
    }

    private SubmissionFeedback getSubmissionFeedback(RunnerOutput runnerOutput) {
        SubmissionFeedback submissionFeedback = new SubmissionFeedback();
        switch (runnerOutput.getRunnerStatus()) {
            case ACCEPTED:
                submissionFeedback.setSubmissionFeedbackStatus(SubmissionFeedbackStatus.ACCEPTED);
            case WRONG_ANSWER:
                submissionFeedback.setSubmissionFeedbackStatus(SubmissionFeedbackStatus.WRONG_ANSWER);
                submissionFeedback.setTestFailed(runnerOutput.getTestFailed());
            case TIME_LIMIT_EXCEEDED:
                submissionFeedback.setSubmissionFeedbackStatus(SubmissionFeedbackStatus.TIME_LIMIT_EXCEEDED);
                submissionFeedback.setTestFailed(runnerOutput.getTestFailed());
        }
        return submissionFeedback;
    }

    private boolean isCompilationError(CompilationOutput compilationOutput) {
        return compilationOutput.getCompilationStatus() == CompilationStatus.FAIL;
    }

    private CompilationOutput compile(String sourceCode, ProgrammingLanguage programmingLanguage) {
        CompilerInput compilerInput = new CompilerInput(sourceCode, programmingLanguage);
        return compilationService.compile(compilerInput);
    }

    private RunnerOutput run(ProgrammingLanguage programmingLanguage, String objectFileName, long problemId) {
        RunnerInput runnerInput = new RunnerInput(programmingLanguage, objectFileName, problemId);
        return testRunnerService.run(runnerInput);
    }


}
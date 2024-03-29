package com.edu.vips.services.submission.impl;

import com.edu.vips.services.storage.api.ProblemStorageService;
import com.edu.vips.services.storage.model.Problem;
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
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemsSubmissionServiceImpl implements ProblemsSubmissionService {

    @Autowired
    private ProblemStorageService problemStorageService;


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
        RunnerOutput runnerOutput = run(submission.getProgrammingLanguage(),
                FilenameUtils.removeExtension(compilationOutput.getObjectFileName()), submission.getProblemId());
        return getSubmissionFeedback(runnerOutput);
    }

    private SubmissionFeedback getSubmissionFeedback(RunnerOutput runnerOutput) {
        SubmissionFeedback submissionFeedback = new SubmissionFeedback();
        switch (runnerOutput.getRunStatus()) {
            case ACCEPTED:
                submissionFeedback.setSubmissionFeedbackStatus(SubmissionFeedbackStatus.ACCEPTED);
                break;
            case WRONG_ANSWER:
                submissionFeedback.setSubmissionFeedbackStatus(SubmissionFeedbackStatus.WRONG_ANSWER);
                break;
            case TIME_LIMIT_EXCEEDED:
                submissionFeedback.setSubmissionFeedbackStatus(SubmissionFeedbackStatus.TIME_LIMIT_EXCEEDED);
                break;
            case RUN_TIME_ERROR:
                submissionFeedback.setSubmissionFeedbackStatus(SubmissionFeedbackStatus.RUNTIME_ERROR);
                break;
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
        Problem problem = problemStorageService.getProblemById(problemId);
        RunnerInput runnerInput = new RunnerInput(programmingLanguage, objectFileName, problem);
        return testRunnerService.run(runnerInput);
    }
}
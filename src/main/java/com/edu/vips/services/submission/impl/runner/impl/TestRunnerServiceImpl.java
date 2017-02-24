package com.edu.vips.services.submission.impl.runner.impl;

import com.edu.vips.services.storage.model.Problem;
import com.edu.vips.services.submission.impl.runner.api.TestRunnerService;
import com.edu.vips.services.submission.impl.runner.model.*;
import com.edu.vips.services.submission.model.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class TestRunnerServiceImpl implements TestRunnerService {

    @Autowired
    private TestCasesFetcher testCasesFetcher;


    @Override
    public RunnerOutput run(RunnerInput runnerInput) {
        TestExecutorTemplate testExecutorTemplate = getTestExecutorTemplate(runnerInput.getProgrammingLanguage());
        RunnerOutput runnerOutput = new RunnerOutput();
        Problem problem = runnerInput.getProblem();
        Iterator<TestCase> testCaseIterator = testCasesFetcher.fetchTests(problem.getId());
        while (testCaseIterator.hasNext()) {
            TestCase testCase = testCaseIterator.next();
            TestExecutorOutput testExecutorOutput = testExecutorTemplate.executeTest(testCase.getInput(),
                    runnerInput.getObjectFileName(), problem.getTimeLimitInMillis());
            switch (testExecutorOutput.getRunStatus()) {
                case OK:
                    boolean isCorrect = verifyAnswer(testExecutorOutput.getOutput(), testCase.getAnswer());
                    if (!isCorrect) {
                        runnerOutput.setRunStatus(RunStatus.WRONG_ANSWER);
                        return runnerOutput;
                    }
                    break;
                case RUN_TIME_ERROR:
                    runnerOutput.setRunStatus(RunStatus.RUN_TIME_ERROR);
                    return runnerOutput;
                case TIME_LIMIT_EXCEEDED:
                    runnerOutput.setRunStatus(RunStatus.TIME_LIMIT_EXCEEDED);
                    return runnerOutput;
            }
        }
        return runnerOutput;
    }

    private boolean verifyAnswer(String output, String answer) {
        return output.equals(answer);
    }

    private TestExecutorTemplate getTestExecutorTemplate(ProgrammingLanguage programmingLanguage) {
        switch (programmingLanguage) {
            case JAVA:
                return new JavaTestExecutor();
            case C:
                return new JavaTestExecutor();
            case CPP:
                return new JavaTestExecutor();
            case PYTHON:
                return new JavaTestExecutor();
            case SCALA:
                return new JavaTestExecutor();
            default:
                throw new IllegalStateException("Unsupported Programming Language");
        }
    }

}

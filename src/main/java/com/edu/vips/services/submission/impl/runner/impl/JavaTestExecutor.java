package com.edu.vips.services.submission.impl.runner.impl;

import com.edu.vips.services.submission.model.ProgrammingLanguage;

public class JavaTestExecutor extends TestExecutorTemplate {
    @Override
    ProcessBuilder createProcessBuilder(String fileName) {
        return new ProcessBuilder(ProgrammingLanguage.JAVA.getExecutionCommand(), fileName);
    }

}

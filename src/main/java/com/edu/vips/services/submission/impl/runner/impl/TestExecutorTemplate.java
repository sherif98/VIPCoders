package com.edu.vips.services.submission.impl.runner.impl;

import com.edu.vips.services.submission.impl.runner.model.TestExecutorOutput;
import com.edu.vips.services.submission.impl.runner.model.TestStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public abstract class TestExecutorTemplate {

    private static final Path binariesPath = Paths.get("C:", "Users", "Admin", "IdeaProjects",
            "VIPCoders", "src", "main", "resources", "static", "tempbinaries");

    abstract ProcessBuilder createProcessBuilder(String fileName);

    public final TestExecutorOutput executeTest(String programInput, String binaryFileName, long timeLimit) {
        TestExecutorOutput testExecutorOutput = new TestExecutorOutput();
        ProcessBuilder processBuilder = createProcessBuilder(binaryFileName);
        processBuilder.directory(binariesPath.toFile());
        Process process = null;
        try {
            process = processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream printStream = new PrintStream(process.getOutputStream());
        printStream.print(programInput);
        System.out.println("program input is " + programInput);
        printStream.close();
        //close
        try {
            if (!process.waitFor(timeLimit, TimeUnit.MILLISECONDS)) {
                testExecutorOutput.setRunStatus(TestStatus.TIME_LIMIT_EXCEEDED);
                return testExecutorOutput;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int exitvalue = process.exitValue();
        if (exitvalue != 0) {
            testExecutorOutput.setRunStatus(TestStatus.RUN_TIME_ERROR);
            return testExecutorOutput;
        }
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        stdInput.lines().forEach(output::append);
        System.out.println(output);
        testExecutorOutput.setOutput(output.toString());
        testExecutorOutput.setRunStatus(TestStatus.OK);
        return testExecutorOutput;
    }
}

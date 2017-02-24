package com.edu.vips.services.submission.impl.compiler.impl;

import com.edu.vips.services.submission.impl.compiler.model.CompilationOutput;
import com.edu.vips.services.submission.impl.compiler.model.CompilationStatus;
import com.edu.vips.services.submission.impl.compiler.model.CompilerInput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

abstract class CompilationProcessTemplate {

    private static final Path binariesPath = Paths.get("C:", "Users", "Admin", "IdeaProjects",
            "VIPCoders", "src", "main", "resources", "static", "tempbinaries");

    abstract String modifyCode(String code);

    abstract ProcessBuilder createProcessBuilder(String fileName);

    abstract String getFileName();

    String generateFileName() {
        return Long.toString(System.currentTimeMillis());
    }

    final CompilationOutput runCompilationProcessTemplate(CompilerInput compilerInput) {
        String fileName = getFileName();
        String modifiedCode = modifyCode(compilerInput.getCode());
        Path filePath = buildPath(fileName);
        saveCodeToFile(modifiedCode, filePath);
        int exitValue = runProcess(fileName);
        cleanUpData(filePath);
        return buildCompilationOutput(exitValue, fileName);
    }


    private int runProcess(String fileName) {
        ProcessBuilder processBuilder = createProcessBuilder(fileName);
        processBuilder.directory(binariesPath.toFile());
        Process process = null;
        try {
            process = processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return process.exitValue();
    }

    private void saveCodeToFile(String code, Path filePath) {
        try {
            Files.write(filePath, code.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Path buildPath(String fileName) {
        return Paths.get(binariesPath.toString(), fileName);
    }

    private CompilationOutput buildCompilationOutput(int exitValue, String fileName) {
        return new CompilationOutput(getCompilationStatus(exitValue), getCompilationOutputFile(exitValue, fileName));
    }

    private CompilationStatus getCompilationStatus(int exitvalue) {
        return exitvalue == 0 ? CompilationStatus.SUCCESS : CompilationStatus.FAIL;
    }

    private String getCompilationOutputFile(int exitValue, String fileName) {
        return exitValue == 0 ? fileName : "";
    }


    private void cleanUpData(Path filePath) {
        try {
            Files.delete(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

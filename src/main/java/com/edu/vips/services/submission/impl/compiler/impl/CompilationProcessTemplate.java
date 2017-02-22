package com.edu.vips.services.submission.impl.compiler.impl;

import com.edu.vips.services.submission.impl.compiler.model.CompilationOutput;
import com.edu.vips.services.submission.impl.compiler.model.CompilationStatus;
import com.edu.vips.services.submission.impl.compiler.model.CompilerInput;
import com.edu.vips.services.submission.model.ProgrammingLanguage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class CompilationProcessTemplate {

    private static final Path binariesPath = Paths.get("C:", "Users", "Admin", "IdeaProjects",
            "VIPCoders", "src", "main", "resources", "static", "tempbinaries");

    abstract String modifyCode(String code);

    abstract String getFileName();

    abstract ProcessBuilder createProcessBuilder(String fileName);

    String generateFileName() {
        return Long.toString(System.currentTimeMillis());
    }

    final CompilationOutput runCompilationProcessTemplate(CompilerInput compilerInput) {
        String fileName = getFileName();
        String modifiedCode = modifyCode(compilerInput.getCode());
        Path filePath = buildPath(fileName);
        saveCodeToFile(modifiedCode, filePath);
        int exitValue = runProcess(compilerInput.getProgrammingLanguage(), fileName);
        return new CompilationOutput(getCompilationStatus(exitValue),
                fileName);
    }

    private int runProcess(ProgrammingLanguage programmingLanguage, String fileName) {
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


    private CompilationStatus getCompilationStatus(int exitvalue) {
        return exitvalue == 0 ? CompilationStatus.SUCCESS : CompilationStatus.FAIL;
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
}

package com.edu.vips.services.submission.impl.compiler.impl;

import com.edu.vips.services.submission.impl.compiler.api.CompilationService;
import com.edu.vips.services.submission.impl.compiler.model.CompilationOutput;
import com.edu.vips.services.submission.impl.compiler.model.CompilationStatus;
import com.edu.vips.services.submission.impl.compiler.model.CompilerInput;
import com.edu.vips.services.submission.model.ProgrammingLanguage;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class CompilationServiceImpl implements CompilationService {

    private static final Path binariesPath = Paths.get("C:", "Users", "Admin", "IdeaProjects",
            "VIPCoders", "src", "main", "resources", "static", "tempbinaries");
    private static final String CLASS_BASE_NAME = "Solution";

    @Override
    public CompilationOutput compile(CompilerInput compilerInput) {
        File sourceCodeFile = saveCodeToFile(compilerInput);
        int exitValue = runCompilationProcess(compilerInput.getProgrammingLanguage(), sourceCodeFile.getName());
        return new CompilationOutput(getCompilationStatus(exitValue),
                removeFileExtension(sourceCodeFile.getName()));
    }

    private int runCompilationProcess(ProgrammingLanguage programmingLanguage, String fileName) {
        ProcessBuilder processBuilder = new ProcessBuilder(programmingLanguage.getCompilationCommand(), fileName);
        System.out.println(fileName);
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

    private String removeFileExtension(String fileName) {
        return FilenameUtils.removeExtension(fileName);
    }

    private File saveCodeToFile(CompilerInput compilerInput) {
        Path filePath = buildPath(compilerInput);
        String newClassName = removeFileExtension(filePath.toFile().getName());
        String modifiedCode = modifyClassName(compilerInput.getCode(), newClassName);
        try {
            Files.write(filePath, modifiedCode.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath.toFile();
    }

    private String modifyClassName(String code, String newClassName) {
        StringBuilder stringBuilder = new StringBuilder(code);
        int clsasNameIndex = stringBuilder.indexOf(CLASS_BASE_NAME);
        stringBuilder.replace(clsasNameIndex, clsasNameIndex + 8, newClassName);
        return stringBuilder.toString();
    }

    private Path buildPath(CompilerInput compilerInput) {
        String fileName = generateFileName();
        return Paths.get(binariesPath.toString(),
                CLASS_BASE_NAME + fileName + compilerInput.getProgrammingLanguage().getFileExtension());
    }

    private String generateFileName() {
        return Long.toString(System.currentTimeMillis());
    }

}

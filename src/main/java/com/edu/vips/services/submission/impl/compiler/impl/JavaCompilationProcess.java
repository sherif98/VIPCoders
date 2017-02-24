package com.edu.vips.services.submission.impl.compiler.impl;

import com.edu.vips.services.submission.model.ProgrammingLanguage;

public class JavaCompilationProcess extends CompilationProcessTemplate {

    private static final String CLASS_BASE_NAME = "Solution";
    private String generatedFileName;

    @Override
    String modifyCode(String code) {
        StringBuilder stringBuilder = new StringBuilder(code);
        int clsasNameIndex = stringBuilder.indexOf(CLASS_BASE_NAME);
        stringBuilder.replace(clsasNameIndex, clsasNameIndex + 8, CLASS_BASE_NAME + generatedFileName);
        return stringBuilder.toString();
    }

    @Override
    String getFileName() {
        generatedFileName = generateFileName();
        return CLASS_BASE_NAME + generateFileName() + ProgrammingLanguage.JAVA.getSourceFileExtension();
    }

    @Override
    ProcessBuilder createProcessBuilder(String fileName) {
        return new ProcessBuilder(ProgrammingLanguage.JAVA.getCompilationCommand(), fileName);
    }
}
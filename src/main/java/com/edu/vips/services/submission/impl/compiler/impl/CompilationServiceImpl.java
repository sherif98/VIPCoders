package com.edu.vips.services.submission.impl.compiler.impl;

import com.edu.vips.services.submission.impl.compiler.api.CompilationService;
import com.edu.vips.services.submission.impl.compiler.model.CompilationOutput;
import com.edu.vips.services.submission.impl.compiler.model.CompilerInput;
import org.springframework.stereotype.Service;

@Service
public class CompilationServiceImpl implements CompilationService {


    @Override
    public CompilationOutput compile(CompilerInput compilerInput) {

        CompilationProcessTemplate compilationProcessTemplate;
        CompilationOutput compilationOutput;
        switch (compilerInput.getProgrammingLanguage()) {
            case C:
                compilationProcessTemplate = new CCompilationProcess();
                compilationOutput = compilationProcessTemplate.runCompilationProcessTemplate(compilerInput);
                break;
            case CPP:
                compilationOutput = null;
                break;
            case JAVA:
                compilationProcessTemplate = new JavaCompilationProcess();
                compilationOutput = compilationProcessTemplate.runCompilationProcessTemplate(compilerInput);
                break;
            case PYTHON:
                compilationOutput = null;
                break;
            case SCALA:
                compilationOutput = null;
                break;
            default:
                throw new IllegalStateException();
        }
        return compilationOutput;
    }
}

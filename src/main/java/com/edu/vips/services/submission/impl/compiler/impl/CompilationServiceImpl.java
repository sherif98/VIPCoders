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
                break;
            case CPP:
                compilationProcessTemplate = new CCompilationProcess();
                break;
            case JAVA:
                compilationProcessTemplate = new JavaCompilationProcess();
                break;
            case PYTHON:
                compilationProcessTemplate = new CCompilationProcess();
                break;
            case SCALA:
                compilationProcessTemplate = new CCompilationProcess();
                break;
            default:
                throw new IllegalStateException("Unsupported Language: cant Compile");
        }
        compilationOutput = compilationProcessTemplate.runCompilationProcessTemplate(compilerInput);
        return compilationOutput;
    }
}

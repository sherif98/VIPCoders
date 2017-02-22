package com.edu.vips.services.submission.impl.compiler.impl;

import com.edu.vips.services.submission.model.ProgrammingLanguage;
import org.apache.commons.io.FilenameUtils;

public class CCompilationProcess extends CompilationProcessTemplate {
    @Override
    String modifyCode(String code) {
        return code;
    }

    @Override
    String getFileName() {
        return generateFileName() + ProgrammingLanguage.C.getFileExtension();
    }

    @Override
    ProcessBuilder createProcessBuilder(String fileName) {
        return new ProcessBuilder(ProgrammingLanguage.C.getCompilationCommand(),
                "-o", FilenameUtils.removeExtension(fileName), fileName);
    }
}

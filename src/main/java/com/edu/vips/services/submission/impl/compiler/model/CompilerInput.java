package com.edu.vips.services.submission.impl.compiler.model;

import com.edu.vips.services.submission.model.ProgrammingLanguage;

public class CompilerInput {
    private String code;
    private ProgrammingLanguage programmingLanguage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
}

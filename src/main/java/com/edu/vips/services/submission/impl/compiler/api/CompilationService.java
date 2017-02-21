package com.edu.vips.services.submission.impl.compiler.api;

import com.edu.vips.services.submission.impl.compiler.model.CompilationOutput;
import com.edu.vips.services.submission.impl.compiler.model.CompilerInput;

public interface CompilationService {
    CompilationOutput compile(CompilerInput compilerInput);
}

package com.edu.vips;

import com.edu.vips.services.submission.impl.compiler.api.CompilationService;
import com.edu.vips.services.submission.impl.compiler.model.CompilationOutput;
import com.edu.vips.services.submission.impl.compiler.model.CompilerInput;
import com.edu.vips.services.submission.model.ProgrammingLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CompilationServiceTest {

    @Autowired
    private CompilationService compilationService;

    @Test
    public void fullCompilationProcess() {
        String code = "public class Solution {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "}";

        CompilerInput compilerInput = new CompilerInput(code, ProgrammingLanguage.JAVA);
        CompilationOutput compilationOutput = compilationService.compile(compilerInput);
        System.out.println(compilationOutput);
    }
}

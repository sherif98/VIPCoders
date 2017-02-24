package com.edu.vips;

import com.edu.vips.services.submission.impl.compiler.api.CompilationService;
import com.edu.vips.services.submission.impl.compiler.model.CompilationOutput;
import com.edu.vips.services.submission.impl.compiler.model.CompilationStatus;
import com.edu.vips.services.submission.impl.compiler.model.CompilerInput;
import com.edu.vips.services.submission.model.ProgrammingLanguage;
import org.junit.Assert;
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
    public void successfulJavaCompilationProcess() {
        String code = "public class Solution {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "}";

        CompilerInput compilerInput = new CompilerInput(code, ProgrammingLanguage.JAVA);
        CompilationOutput compilationOutput = compilationService.compile(compilerInput);
        System.out.println(compilationOutput);
        Assert.assertEquals(CompilationStatus.SUCCESS, compilationOutput.getCompilationStatus());
    }

    @Test
    public void successfulCCompilationProcess() {
        String code = "#include <stdio.h>\n" +
                "#include <stdlib.h>\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "    printf(\"Hello world!\\n\");\n" +
                "    return 0;\n" +
                "}\n";

        CompilerInput compilerInput = new CompilerInput(code, ProgrammingLanguage.C);
        CompilationOutput compilationOutput = compilationService.compile(compilerInput);
        System.out.println(compilationOutput);
        Assert.assertEquals(CompilationStatus.SUCCESS, compilationOutput.getCompilationStatus());
    }
    @Test
    public void failureJavaCompilationProcess() {
        String code = "public class Solution {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "";//missing curly brace

        CompilerInput compilerInput = new CompilerInput(code, ProgrammingLanguage.JAVA);
        CompilationOutput compilationOutput = compilationService.compile(compilerInput);
        System.out.println(compilationOutput);
        Assert.assertEquals(CompilationStatus.FAIL, compilationOutput.getCompilationStatus());
    }
    @Test
    public void failureCCompilationProcess() {
        String code = "#include <stdio.h>\n" +
                "#include <stdlib.h>\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "    printf(\"Hello world!\\n\");\n" +
                "    return 0;\n" +
                "\n";//missing curly brace

        CompilerInput compilerInput = new CompilerInput(code, ProgrammingLanguage.C);
        CompilationOutput compilationOutput = compilationService.compile(compilerInput);
        System.out.println(compilationOutput);
        Assert.assertEquals(CompilationStatus.FAIL, compilationOutput.getCompilationStatus());
    }
}

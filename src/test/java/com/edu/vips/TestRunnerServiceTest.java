package com.edu.vips;

import com.edu.vips.services.storage.model.Problem;
import com.edu.vips.services.submission.impl.runner.api.TestRunnerService;
import com.edu.vips.services.submission.impl.runner.model.RunnerInput;
import com.edu.vips.services.submission.impl.runner.model.RunnerOutput;
import com.edu.vips.services.submission.model.ProgrammingLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRunnerServiceTest {

    @Autowired
    private TestRunnerService testRunnerService;


    @Test
    public void javaRunningTest() {
        Problem problem = new Problem();
        problem.setId(1);
        problem.setTimeLimitInMillis(1000);
        RunnerInput runnerInput = new RunnerInput(ProgrammingLanguage.JAVA, "Solution1487968245690", problem);
        RunnerOutput runnerOutput = testRunnerService.run(runnerInput);
        System.out.println(runnerOutput);
    }
}

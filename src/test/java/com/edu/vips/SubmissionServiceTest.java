package com.edu.vips;

import com.edu.vips.services.storage.api.ProblemStorageService;
import com.edu.vips.services.storage.model.Problem;
import com.edu.vips.services.submission.api.ProblemsSubmissionService;
import com.edu.vips.services.submission.model.ProgrammingLanguage;
import com.edu.vips.services.submission.model.Submission;
import com.edu.vips.services.submission.model.SubmissionFeedback;
import com.edu.vips.services.submission.model.SubmissionFeedbackStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubmissionServiceTest {

    @Mock
    private ProblemStorageService problemStorageService;

    @Autowired
    @InjectMocks
    private ProblemsSubmissionService problemsSubmissionService;

    @Test
    public void javaAddTwoNumbers() {
        Problem problem = new Problem();
        problem.setId(1);
        problem.setTimeLimitInMillis(1000);
        String code = "import java.util.Scanner;\n" +
                "public class Solution{\n" +
                "    public static void main(String [] args){\n" +
                "        Scanner in = new Scanner(System.in);\n" +
                "        int a = in.nextInt();\n" +
                "        int b = in.nextInt();\n" +
                "        System.out.println(a + b);\n" +
                "    }\n" +
                "\n" +
                "}";
        when(problemStorageService.getProblemById(1)).thenReturn(problem);
        Submission submission = new Submission(1, 1, ProgrammingLanguage.JAVA, code);
        SubmissionFeedback submissionFeedback = problemsSubmissionService.submit(submission);
        System.out.println(submissionFeedback);
        Assert.assertEquals(SubmissionFeedbackStatus.ACCEPTED, submissionFeedback.getSubmissionFeedbackStatus());
    }

    @Test
    public void javaAddArrayOfNumbers() {
        Problem problem = new Problem();
        problem.setId(2);
        problem.setTimeLimitInMillis(1000);
        String code = "import java.util.Scanner;\n" +
                "public class Solution{\n" +
                "    public static void main(String [] args){\n" +
                "        Scanner in = new Scanner(System.in);\n" +
                "        int n = in.nextInt();\n" +
                "        int [] a = new int[n];\n" +
                "        for(int i = 0; i < n; i++){\n" +
                "            a[i] = in.nextInt();\n" +
                "        }\n" +
                "        int sum = 0;\n" +
                "        for(int i = 0; i < n; i++){\n" +
                "            sum += a[i];\n" +
                "        }\n" +
                "        System.out.println(sum);\n" +
                "    }\n" +
                "\n" +
                "}";
        when(problemStorageService.getProblemById(2)).thenReturn(problem);
        Submission submission = new Submission(1, 2, ProgrammingLanguage.JAVA, code);
        SubmissionFeedback submissionFeedback = problemsSubmissionService.submit(submission);
        System.out.println(submissionFeedback);
        Assert.assertEquals(SubmissionFeedbackStatus.ACCEPTED, submissionFeedback.getSubmissionFeedbackStatus());
    }
}

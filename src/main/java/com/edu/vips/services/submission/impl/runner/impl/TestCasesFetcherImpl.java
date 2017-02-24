package com.edu.vips.services.submission.impl.runner.impl;

import com.edu.vips.services.submission.impl.runner.model.TestCase;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

@Service
class TestCasesFetcherImpl implements TestCasesFetcher {

    private static final String INPUT = "input";
    private static final String OUTPUT = "output";

    private static final Path problemsTestsPath = Paths.get("C:", "Users", "Admin", "IdeaProjects",
            "VIPCoders", "src", "main", "resources", "static", "problems");

    @Override
    public Iterator<TestCase> fetchTests(long problemId) {
//        Iter iterator = new Iter(problemId);
//        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);
        return new Iter(problemId);
    }


    private class Iter implements Iterator<TestCase> {
        private int idx;
        private File[] problemTests;

        Iter(long problemId) {
            Path path = Paths.get(problemsTestsPath.toString(), Long.toString(problemId));
            problemTests = path.toFile().listFiles();
        }

        @Override
        public boolean hasNext() {
            return idx < problemTests.length;
        }

        @Override
        public TestCase next() {
            File testDirectory = problemTests[idx++];
            File[] test = testDirectory.listFiles();
            return createTestCase(test);
        }

        private TestCase createTestCase(File[] test) {
            TestCase testCase = new TestCase();
            String input;
            String output;
            if (test[0].getName().equals(INPUT) && test[1].getName().equals(OUTPUT)) {
                input = getData(test[0]);
                output = getData(test[1]);
            } else {
                input = getData(test[1]);
                output = getData(test[0]);
            }
            testCase.setInput(input);
            testCase.setAnswer(output);
            return testCase;
        }


        private String getData(File inputFile) {
            StringBuilder input = new StringBuilder();
            List<String> inputList = null;
            try {
                inputList = Files.readAllLines(inputFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            inputList.forEach(input::append);
            return input.toString();
        }
    }
}

package com.edu.vips.services.submission.impl.runner.model;

public class TestCase {
    private String input;
    private String answer;

    public String getInput() {
        return input;
    }

    public String getAnswer() {
        return answer;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "input='" + input + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}

package com.edu.vips.services.submission.impl.runner.impl;

import com.edu.vips.services.submission.impl.runner.model.TestCase;

import java.util.Iterator;

interface TestCasesFetcher {
    Iterator<TestCase> fetchTests(long problemId);
}

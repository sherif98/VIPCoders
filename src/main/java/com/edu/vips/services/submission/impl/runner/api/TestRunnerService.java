package com.edu.vips.services.submission.impl.runner.api;

import com.edu.vips.services.submission.impl.runner.model.RunnerInput;
import com.edu.vips.services.submission.impl.runner.model.RunnerOutput;

public interface TestRunnerService {
    RunnerOutput run(RunnerInput runnerInput);
}

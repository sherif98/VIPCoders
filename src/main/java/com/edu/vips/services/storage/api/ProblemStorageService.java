package com.edu.vips.services.storage.api;

import com.edu.vips.services.storage.model.Problem;

public interface ProblemStorageService {
    Problem getProblemById(long problemId);
}

package com.edu.vips.services.storage.impl;

import com.edu.vips.dao.api.ProblemsRepository;
import com.edu.vips.services.storage.api.ProblemStorageService;
import com.edu.vips.services.storage.model.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemStorageServiceImpl implements ProblemStorageService {
    @Autowired
    private ProblemsRepository problemsRepository;

    @Override
    public Problem getProblemById(long problemId) {

//        return problemsRepository.findOne(problemId);
        return null;
    }
}

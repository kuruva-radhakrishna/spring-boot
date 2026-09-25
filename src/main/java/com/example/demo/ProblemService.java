package com.example.demo;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {

    private final List<Problem> problems = new ArrayList<>();

    public List<Problem> getAll() {
        return problems;
    }

    public Problem add(Problem problem) {
        problems.add(problem);
        return problem;
    }
}
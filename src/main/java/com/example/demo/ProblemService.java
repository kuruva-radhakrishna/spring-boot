package com.example.demo;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {

    private  final ProblemRepository  probRepo;

    public ProblemService(ProblemRepository problemRepository){
        this.probRepo = problemRepository;
    }

    public List<Problem> getAll() {
        return probRepo.findAll();
    }

    public Problem add(Problem problem) {
        return probRepo.save(problem);
    }

    public Problem getProblemById(Long Id){
        return probRepo.findById(Id).orElseThrow(()-> new ProblemNotFoundException(Id));
        
    }

    public List<Problem> search(String difficulty, String title) {
        if (difficulty != null && title != null)
            return probRepo.findByDifficultyAndTitleContaining(difficulty, title);
        if (difficulty != null)
            return probRepo.findByDifficulty(difficulty);
        if (title != null)
            return probRepo.findByTitleContaining(title);
        return probRepo.findAll();
    }

}
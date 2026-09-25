package com.example.demo;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
    List<Problem> findByDifficulty(String difficulty);
    List<Problem> findByTitleContaining(String title);
    List<Problem> findByDifficultyAndTitleContaining(String difficulty, String title);
}
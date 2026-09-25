package com.example.demo;

public class ProblemNotFoundException extends RuntimeException {
    public ProblemNotFoundException(Long id) {
        super("Problem not found with id " + id);
    }
}
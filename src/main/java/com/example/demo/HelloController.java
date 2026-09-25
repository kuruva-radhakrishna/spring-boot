package com.example.demo;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.*;

@RestController
public class HelloController {

    private final ProblemService problemService;

    public HelloController(ProblemService problemService){
        this.problemService = problemService;
    } 

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/problems/{id}")
    public Problem getProblem(@PathVariable Long id) {
        return problemService.getProblemById(id);
    }

    @GetMapping("/problems")
    public List<Problem> getProblems(){
        return problemService.getAll();
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name){
        return "Hello " + name;
    }

    @PostMapping("/problems")
    public ResponseEntity<Problem> postProblems(@Valid @RequestBody Problem problem){
        Problem save =  problemService.add(problem);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping("/problems/search")
    public List<Problem> search(@RequestParam(required = false) String difficulty,
                                @RequestParam(required = false) String title) {
        return problemService.search(difficulty, title);
    }
}
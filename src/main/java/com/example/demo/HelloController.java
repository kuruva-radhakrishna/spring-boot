package com.example.demo;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    final ProblemService problemService;

    public HelloController(ProblemService problemService){
        this.problemService = problemService;
    } 

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/problems/{id}")
    public Problem getProblem(@PathVariable String id) {
        return new Problem(id,"New Problem","Hard");
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
    public Problem postProblems(@RequestBody Problem problem){
        return problemService.add(problem);
        
    }
}
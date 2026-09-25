package com.example.demo;

import java.lang.annotation.Inherited;
import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.web.bind.annotation.*;

@Entity
public class Problem{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Difficulty is required")
    @Pattern(regexp = "Easy|Medium|Hard", message = "Difficulty must be Easy, Medium, or Hard")
    private String difficulty;

    public Problem(){}

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDifficulty() { return difficulty; }

    public void setTitle(String title) { this.title = title; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }


}
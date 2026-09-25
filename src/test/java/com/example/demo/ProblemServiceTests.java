package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class ProblemServiceTests {

    ProblemRepository repo = mock(ProblemRepository.class);
    ProblemService service = new ProblemService(repo);

    @Test
    void returnsProblemWhenFound() {
        Problem p = new Problem();
        p.setTitle("Two Sum");
        when(repo.findById(1L)).thenReturn(Optional.of(p));

        Problem result = service.getProblemById(1L);

        assertEquals("Two Sum", result.getTitle());
    }

    @Test
    void throwsWhenMissing() {
        when(repo.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ProblemNotFoundException.class,
                     () -> service.getProblemById(99L));
    }

    @Test
    void searchByDifficultyOnlyUsesFindByDifficulty() {
        // 1. ARRANGE: nothing to set up.
        //    The mock returns an empty list by default, which is fine here.

        // 2. ACT: call search with only difficulty
        service.search("Easy", null);

        // 3. ASSERT: check the right repository method was called
        verify(repo).findByDifficulty("Easy");
        verify(repo, never()).findByDifficultyAndTitleContaining(any(), any());
    }
}
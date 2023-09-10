package com.example.demo.Services;

import com.example.demo.Exceptions.NoQuestionsAvailableException;
import com.example.demo.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    public void testGetQuestions() {
        List<Question> allQuestions = new ArrayList<>();
        allQuestions.add(new Question("Q1", "A1"));
        allQuestions.add(new Question("Q2", "A2"));
        allQuestions.add(new Question("Q3", "A3"));

        when(questionService.getAllQuestions()).thenReturn(allQuestions);

        List<Question> selectedQuestions = examinerService.getQuestions(2);

        assertEquals(2, selectedQuestions.size());
        assertTrue(allQuestions.containsAll(selectedQuestions));
    }

    @Test
    public void testGetQuestions_NotEnoughQuestions() {
        List<Question> allQuestions = new ArrayList<>();
        allQuestions.add(new Question("Q1", "A1"));

        when(questionService.getAllQuestions()).thenReturn(allQuestions);

        assertThrows(NoQuestionsAvailableException.class, () -> examinerService.getQuestions(2));
    }
}
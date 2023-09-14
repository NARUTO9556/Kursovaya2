package com.example.demo.Services;

import com.example.demo.Exceptions.NoQuestionsAvailableException;
import com.example.demo.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    public void testGetQuestions() {
        Question question1 = new Question("Q1", "A1");
        Question question2 = new Question("Q2", "A2");

        when(questionService.getRandomQuestion()).thenReturn(question1, question1, question2);

        Set<Question> questions = examinerService.getQuestions(2);

        assertEquals(2, questions.size());
        assertTrue(questions.contains(question1));
        assertTrue(questions.contains(question2));
    }

    @Test
    public void testGetQuestions_NotEnoughQuestions() {
        List<Question> allQuestions = new ArrayList<>();
        allQuestions.add(new Question("Q1", "A1"));

        when(questionService.getAllQuestions()).thenReturn(allQuestions);

        assertThrows(NoQuestionsAvailableException.class, () -> examinerService.getQuestions(2));
    }
}
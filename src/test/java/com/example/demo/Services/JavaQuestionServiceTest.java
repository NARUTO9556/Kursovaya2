package com.example.demo.Services;

import com.example.demo.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;
    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void addQuestion() {
        Question question = new Question("Что такое класс в Java?", "Схема создания объектов");
        javaQuestionService.addQuestion(question);
        List<Question> allQuestions = javaQuestionService.getAllQuestions();
        assertEquals(1, allQuestions.size());
        assertEquals(question, allQuestions.get(0));
    }

    @Test
    void removeQuestion() {
        Question question = new Question("Что такое класс в Java?", "Схема создания объектов");
        javaQuestionService.addQuestion(question);
        List<Question> allQuestion = javaQuestionService.getAllQuestions();
        assertEquals(1, allQuestion.size());
        javaQuestionService.removeQuestion(question);
        List<Question> allQuestions = javaQuestionService.getAllQuestions();
        assertEquals(0,allQuestions.size());
    }

    @Test
    void getAllQuestions() {
        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");
        Question question3 = new Question("Question 3", "Answer 3");

        javaQuestionService.addQuestion(question1);
        javaQuestionService.addQuestion(question2);
        javaQuestionService.addQuestion(question3);

        List<Question> allQuestions = javaQuestionService.getAllQuestions();
        assertEquals(3, allQuestions.size());
        assertTrue(allQuestions.contains(question1));
        assertTrue(allQuestions.contains(question2));
        assertTrue(allQuestions.contains(question3));
    }

    @Test
    void getRandomQuestion() {
        javaQuestionService.addQuestion(new Question("Question 1", "Answer 1"));
        javaQuestionService.addQuestion(new Question("Question 2", "Answer 2"));
        javaQuestionService.addQuestion(new Question("Question 3", "Answer 3"));

        Question randomQuestion = javaQuestionService.getRandomQuestion();

        List<Question> allQuestions = javaQuestionService.getAllQuestions();
        assertTrue(allQuestions.contains(randomQuestion));
    }

    @Test
    void testGetRandomQuestionWhenNoQuestionsExist() {
        assertThrows(RuntimeException.class, () -> javaQuestionService.getRandomQuestion());
    }
}
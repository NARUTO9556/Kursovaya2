package com.example.demo.services;

import com.example.demo.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private QuestionService out;

    @BeforeEach
    void beforeEach() {
        out = new JavaQuestionService();
        out.addQuestion(new Question("qwe", "ewq"));
        out.addQuestion(new Question("asd", "dsa"));
        out.addQuestion(new Question("zxc", "cxz"));
    }

    @Test
    void shouldReturnCollectionWithQuestions() {
        Set<Question> expected = new HashSet<>(Set.of(
                new Question("qwe", "ewq"),
                new Question("asd", "dsa"),
                new Question("zxc", "cxz")
        ));

        assertIterableEquals(expected, out.getAllQuestions());
    }

    @Test
    void shouldReturnQuestionAfterAddAndCorrectCollection() {
        Set<Question> expectedSet = new HashSet<>(Set.of(
                new Question("qwe", "ewq"),
                new Question("asd", "dsa"),
                new Question("zxc", "cxz"),
                new Question("iop", "poi")
        ));
        Question expectedQuestion = new Question("iop", "poi");

        assertEquals(expectedQuestion, out.addQuestion(new Question("iop", "poi")));
        assertIterableEquals(expectedSet, out.getAllQuestions());
    }

    @Test
    void shouldReturnQuestionAfterRemoveAndCorrectCollection() {
        Set<Question> expectedSet = new HashSet<>(Set.of(
                new Question("asd", "dsa"),
                new Question("zxc", "cxz")
        ));
        Question expectedQuestion = new Question("qwe", "ewq");

        assertEquals(expectedQuestion, out.removeQuestion(new Question("qwe", "ewq")));
        assertIterableEquals(expectedSet, out.getAllQuestions());
    }

    @Test
    void shouldReturnTrueAfterRandom() {
        assertTrue(out.getAllQuestions().contains(out.getRandomQuestion()));
    }
}
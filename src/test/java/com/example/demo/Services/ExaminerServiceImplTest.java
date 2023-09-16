package com.example.demo.Services;

import com.example.demo.Exceptions.NoQuestionsAvailableException;
import com.example.demo.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {@Mock
private QuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    private final Collection<Question> questions = new HashSet<>(Set.of(
            new Question("qwe", "ewq"),
            new Question("asd", "dsa"),
            new Question("zxc", "cxz")));

    @Test
    void shouldReturnExceptionWhenAmountIncorrect() {
        when(questionServiceMock.getAllQuestions()).thenReturn(questions);

        assertThrows(NoQuestionsAvailableException.class, () -> out.getQuestions(questions.size() + 1));
    }

    @Test
    void shouldReturnSetWithAmountQuestions() {
        when(questionServiceMock.getAllQuestions()).thenReturn(questions);
        when(questionServiceMock.getRandomQuestion()).thenReturn(
                new Question("qwe", "ewq"),
                new Question("zxc", "cxz"),
                new Question("zxc", "cxz"),
                new Question("asd", "dsa"),
                new Question("qwe", "ewq")
        );

        assertIterableEquals(questions, out.getQuestions(3));
    }
}
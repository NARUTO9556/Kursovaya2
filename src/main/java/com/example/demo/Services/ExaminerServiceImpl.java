package com.example.demo.Services;

import com.example.demo.Exceptions.NoQuestionsAvailableException;
import com.example.demo.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            Question question = questionService.getRandomQuestion();
            if (question == null) {
                throw new NoQuestionsAvailableException("Недостаточно вопросов");
            }
            questions.add(question);
        }
        return questions;
    }
}

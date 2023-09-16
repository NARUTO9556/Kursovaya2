package com.example.demo.Services;

import com.example.demo.Exceptions.NoQuestionsAvailableException;
import com.example.demo.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAllQuestions().size()) {
            throw new NoQuestionsAvailableException("");
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            Question question = questionService.getRandomQuestion();
            questions.add(question);
        }
        return questions;
    }
}

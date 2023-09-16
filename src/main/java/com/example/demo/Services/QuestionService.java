package com.example.demo.Services;

import com.example.demo.model.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionService {
    Question addQuestion(String question, String answer);
    Question addQuestion(Question question);
    Question removeQuestion(Question question);
    Collection<Question> getAllQuestions();
    Question getRandomQuestion();
}

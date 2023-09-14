package com.example.demo.Services;

import com.example.demo.model.Question;

import java.util.List;

public interface QuestionService {
    void addQuestion(String question, String answer);
    void addQuestion(Question question);
    void removeQuestion(Question question);
    List<Question> getAllQuestions();
    Question getRandomQuestion();
}

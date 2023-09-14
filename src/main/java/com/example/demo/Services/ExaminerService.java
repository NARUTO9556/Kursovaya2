package com.example.demo.Services;

import com.example.demo.Exceptions.NoQuestionsAvailableException;
import com.example.demo.model.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount) throws NoQuestionsAvailableException;
}

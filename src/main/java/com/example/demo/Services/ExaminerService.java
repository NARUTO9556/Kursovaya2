package com.example.demo.Services;

import com.example.demo.Exceptions.NoQuestionsAvailableException;
import com.example.demo.model.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount) throws NoQuestionsAvailableException;
}

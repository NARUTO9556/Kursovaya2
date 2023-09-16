package com.example.demo.Services;

import com.example.demo.Exceptions.NoQuestionsAvailableException;
import com.example.demo.model.Question;

import java.util.Collection;
import java.util.Set;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}

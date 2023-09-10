package com.example.demo.Services;

import com.example.demo.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> javaQuestions;

    public JavaQuestionService() {
        javaQuestions = new ArrayList<>();
    }
    @Override
    public void addQuestion(Question question) {
        javaQuestions.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        javaQuestions.remove(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return javaQuestions;
    }

    @Override
    public Question getRandomQuestion() {
        if (javaQuestions.isEmpty()) {
            throw new RuntimeException("Нет доступных вопросов по Java.");
        }
        Random random = new Random();
        int randomIndex = random.nextInt(javaQuestions.size());
        return javaQuestions.get(randomIndex);
    }
}

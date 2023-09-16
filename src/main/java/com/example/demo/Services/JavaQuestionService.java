package com.example.demo.Services;

import com.example.demo.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;
    private final Random random = new Random();

    public JavaQuestionService() {
        questions = new HashSet<>();
    }

    @Override
    public Question addQuestion(String question, String answer) {
        Question item = new Question(question, answer);
        questions.add(item);
        return item;
    }

    @Override
    public Question addQuestion(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int max = questions.size();
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get((int) (Math.random() * max));
    }
}

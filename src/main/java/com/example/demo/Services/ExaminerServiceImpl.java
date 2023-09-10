package com.example.demo.Services;

import com.example.demo.Exceptions.NoQuestionsAvailableException;
import com.example.demo.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    private Random random = new Random();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        List<Question> allQuestions = questionService.getAllQuestions();
        int totalQuestions = allQuestions.size();

        if (amount > totalQuestions) {
            throw new NoQuestionsAvailableException("Not enough questions available.");
        }

        List<Question> selectedQuestions = new ArrayList<>();
        List<Integer> selectedIndices = new ArrayList<>();

        while (selectedQuestions.size() < amount) {
            int randomIndex = random.nextInt(totalQuestions);

            if (!selectedIndices.contains(randomIndex)) {
                selectedIndices.add(randomIndex);
                selectedQuestions.add(allQuestions.get(randomIndex));
            }
        }
        return selectedQuestions;
    }
}

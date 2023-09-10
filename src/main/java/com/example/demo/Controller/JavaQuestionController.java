package com.example.demo.Controller;

import com.example.demo.Services.JavaQuestionService;
import com.example.demo.Services.QuestionService;
import com.example.demo.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private JavaQuestionService questionService;
    @Autowired
    public JavaQuestionController(JavaQuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping("/add")
    public String addQuestion(@RequestParam String questionText, String questionAnswer) {
        Question question = new Question(questionText, questionAnswer);
        questionService.addQuestion(question);
        return "Вопрос добавлен успешно";
    }
    @DeleteMapping("/remove")
    public String removeQuestion(@RequestParam String questionText, String questionAnswer) {
        Question question = new Question(questionText, questionAnswer);
        questionService.removeQuestion(question);
        return "Вопрос удален успешно";
    }
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}

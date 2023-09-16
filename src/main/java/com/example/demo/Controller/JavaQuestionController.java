package com.example.demo.Controller;

import com.example.demo.Services.JavaQuestionService;
import com.example.demo.Services.QuestionService;
import com.example.demo.model.Question;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;
    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping("/add")
    public Question addQuestion(@RequestParam String questionText,@RequestParam String questionAnswer) {
        Question question = new Question(questionText, questionAnswer);
        questionService.addQuestion(question);
        return question;
    }
    @DeleteMapping("/remove")
    public Question removeQuestion(@RequestParam String questionText,@RequestParam String questionAnswer) {
        Question question = new Question(questionText, questionAnswer);
        questionService.removeQuestion(question);
        return question;
    }
    @GetMapping
    public Collection<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}

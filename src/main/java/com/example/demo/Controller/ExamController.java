package com.example.demo.Controller;

import com.example.demo.Exceptions.NoQuestionsAvailableException;
import com.example.demo.Services.ExaminerService;
import com.example.demo.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/exam")
public class ExamController {
    private ExaminerService examinerService;
    @Autowired
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/questions")
    public List<Question> getQuestions(@RequestParam int amount) throws NoQuestionsAvailableException {
        return examinerService.getQuestions(amount);
    }
}

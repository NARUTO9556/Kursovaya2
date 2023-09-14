package com.example.demo.Controller;

import com.example.demo.Exceptions.NoQuestionsAvailableException;
import com.example.demo.Services.ExaminerService;
import com.example.demo.model.Question;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/get/{amount}")
    public Set<Question> getQuestions(@PathVariable int amount) throws NoQuestionsAvailableException {
        return examinerService.getQuestions(amount);
    }
}

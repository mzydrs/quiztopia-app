package com.quiztopia.controller;

import com.quiztopia.dto.QuizDto;
import com.quiztopia.model.Quiz;
import com.quiztopia.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    private QuizDto convertToDto(Quiz quiz) {
        List<Long> questionIds = quiz.getQuestions().stream()
                .map(question -> question.getId())
                .collect(Collectors.toList());

        return new QuizDto(quiz.getId(), quiz.getTitle(), quiz.getDescription(), questionIds);
    }

    @GetMapping
    public List<QuizDto> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return quizzes.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody QuizDto quizDto) {
        Quiz quiz = new Quiz();
        quiz.setTitle(quizDto.getTitle());
        quiz.setDescription(quizDto.getDescription());
        quiz.setQuestions(null);

        return quizService.createQuiz(null);
    }

    @GetMapping("/{id}")
    public QuizDto getQuiz(@PathVariable Long id) {
        Quiz quiz = quizService.getQuizById(id);
        return convertToDto(quiz);
    }
}

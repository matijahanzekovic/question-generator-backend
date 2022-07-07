package hr.tvz.hanzekovic.questiongenerator.controller;

import hr.tvz.hanzekovic.questiongenerator.dto.QuestionGeneratorDto;
import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.facade.QuestionGeneratorFacade;
import hr.tvz.hanzekovic.questiongenerator.form.QuizForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class QuestionGeneratorController {

    private final QuestionGeneratorFacade facade;

    @PostMapping("/api/generate")
    public ResponseEntity<List<QuestionGeneratorDto>> generateQuestion(@RequestBody final String text) {
        return ResponseEntity.ok(facade.generateQuestion(text));
    }

    @GetMapping("/api/get-quiz/{id}")
    public ResponseEntity<QuizDto> getQuiz(@PathVariable final Long id) {
        return ResponseEntity.ok(facade.getQuiz(id));
    }

    @PostMapping("/api/create-quiz")
    public ResponseEntity<QuizDto> createQuiz(@RequestBody final QuizForm form) {
        return ResponseEntity.ok(facade.createQuiz(form));
    }

}

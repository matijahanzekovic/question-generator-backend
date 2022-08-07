package hr.tvz.hanzekovic.questiongenerator.controller;

import hr.tvz.hanzekovic.questiongenerator.dto.QuestionGeneratorDto;
import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.facade.QuestionGeneratorFacade;
import hr.tvz.hanzekovic.questiongenerator.form.CreateQuizForm;
import hr.tvz.hanzekovic.questiongenerator.form.SolveQuizForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class QuestionGeneratorController {

    private final QuestionGeneratorFacade facade;

    @PostMapping("/generate")
    public ResponseEntity<List<QuestionGeneratorDto>> generateQuestion(@RequestBody final String text) {
        return ResponseEntity.ok(facade.generateQuestions(text));
    }

    @GetMapping("/get-quiz/{id}")
    public ResponseEntity<QuizDto> getQuiz(@PathVariable final Long id) {
        return ResponseEntity.ok(facade.getQuiz(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<QuestionGeneratorDto>> getAllQuestionAnswers() {
        return ResponseEntity.ok(facade.getAllQuestionAnswers());
    }

    @PostMapping("/create-quiz")
    public ResponseEntity<QuizDto> createQuiz(@RequestBody final CreateQuizForm form) {
        return ResponseEntity.ok(facade.createQuiz(form));
    }

    @PostMapping("/solve-quiz")
    public ResponseEntity<QuizDto> solveQuiz(@RequestBody final SolveQuizForm form) {
        return ResponseEntity.ok(facade.solveQuiz(form));
    }

}

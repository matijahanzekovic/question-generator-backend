package hr.tvz.hanzekovic.questiongenerator.facade.impl;

import hr.tvz.hanzekovic.questiongenerator.domain.Quiz;
import hr.tvz.hanzekovic.questiongenerator.dto.QuestionGeneratorDto;
import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.facade.QuestionGeneratorFacade;
import hr.tvz.hanzekovic.questiongenerator.form.CreateQuizForm;
import hr.tvz.hanzekovic.questiongenerator.form.SolveQuizForm;
import hr.tvz.hanzekovic.questiongenerator.integration.model.QuestionGeneratorResponse;
import hr.tvz.hanzekovic.questiongenerator.integration.service.QuestionGeneratorIntegrationService;
import hr.tvz.hanzekovic.questiongenerator.service.QuestionAnswerService;
import hr.tvz.hanzekovic.questiongenerator.service.QuizQuestionAnswerService;
import hr.tvz.hanzekovic.questiongenerator.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class QuestionGeneratorFacadeImpl implements QuestionGeneratorFacade {

    private final EntityManager entityManager;
    private final QuestionAnswerService questionAnswerService;
    private final QuestionGeneratorIntegrationService integrationService;
    private final QuizService quizService;
    private final QuizQuestionAnswerService quizQuestionAnswerService;

    @Override
    @Transactional
    public List<QuestionGeneratorDto> generateQuestions(final String text) {
        try {
            final ResponseEntity<List<QuestionGeneratorResponse>> response = integrationService.generate(text);
            if (response.getStatusCode().is2xxSuccessful() && Objects.nonNull(response.getBody())) {
                return questionAnswerService.save(response.getBody());
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed integration with question-generator-nlp service. Exception: ", e);
        }

        return List.of();
    }

    @Override
    public QuizDto getQuiz(final Long id) {
        return quizService.getQuizById(id);
    }

    @Override
    @Transactional
    public QuizDto createQuiz(final CreateQuizForm form) {
        final Quiz quiz = quizService.save(form);
        quizQuestionAnswerService.save(quiz.getId(), form.getQuestionAnswerIds());

        entityManager.clear();

        return getQuiz(quiz.getId());
    }

    @Override
    @Transactional
    public QuizDto solveQuiz(final SolveQuizForm form) {
        quizQuestionAnswerService.solveQuiz(form);
        entityManager.clear();

        return getQuiz(form.getQuizId());
    }

    @Override
    public List<QuestionGeneratorDto> getAllQuestionAnswers() {
        return questionAnswerService.getAllQuestionAnswers();
    }

    @Override
    public List<QuizDto> getQuizList() {
        return quizService.getQuizList();
    }


}

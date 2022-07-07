package hr.tvz.hanzekovic.questiongenerator.facade.impl;

import hr.tvz.hanzekovic.questiongenerator.domain.Quiz;
import hr.tvz.hanzekovic.questiongenerator.dto.QuestionGeneratorDto;
import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.facade.QuestionGeneratorFacade;
import hr.tvz.hanzekovic.questiongenerator.form.QuizForm;
import hr.tvz.hanzekovic.questiongenerator.integration.model.QuestionGeneratorResponse;
import hr.tvz.hanzekovic.questiongenerator.integration.service.QuestionGeneratorIntegrationService;
import hr.tvz.hanzekovic.questiongenerator.service.QuestionAnswerService;
import hr.tvz.hanzekovic.questiongenerator.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class QuestionGeneratorFacadeImpl implements QuestionGeneratorFacade {

    private final QuestionAnswerService questionAnswerService;
    private final QuestionGeneratorIntegrationService integrationService;
    private final QuizService quizService;

    @Override
    @Transactional
    public List<QuestionGeneratorDto> generateQuestion(final String text) {
        final ResponseEntity<List<QuestionGeneratorResponse>> response = integrationService.generate(text);

        if (response.getStatusCode().is2xxSuccessful() && Objects.nonNull(response.getBody())) {
            return questionAnswerService.save(response.getBody());
        }

        return List.of();
    }

    @Override
    public QuizDto getQuiz(final Long id) {
        return quizService.getQuizById(id);
    }

    @Override
    @Transactional
    public QuizDto createQuiz(final QuizForm form) {
        final Quiz quiz = quizService.save(form);
        questionAnswerService.update(quiz.getId(), form.getQuestionAnswerIds());

        return getQuiz(quiz.getId());
    }

}

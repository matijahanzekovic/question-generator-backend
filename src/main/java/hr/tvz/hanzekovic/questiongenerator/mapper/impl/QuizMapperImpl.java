package hr.tvz.hanzekovic.questiongenerator.mapper.impl;

import hr.tvz.hanzekovic.questiongenerator.domain.Distractor;
import hr.tvz.hanzekovic.questiongenerator.domain.Quiz;
import hr.tvz.hanzekovic.questiongenerator.domain.QuizQuestionAnswer;
import hr.tvz.hanzekovic.questiongenerator.dto.QuestionGeneratorDto;
import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.form.CreateQuizForm;
import hr.tvz.hanzekovic.questiongenerator.mapper.QuizMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class QuizMapperImpl implements QuizMapper {

    @Override
    public Quiz toEntity(final CreateQuizForm form) {
        if (Objects.isNull(form)) {
            return null;
        }

        return Quiz.builder()
                .name(form.getName())
                .date(LocalDate.now())
                .build();
    }

    @Override
    public QuizDto toDto(final Quiz quiz) {
        if (Objects.isNull(quiz)) {
            return null;
        }

        return QuizDto.builder()
                .id(quiz.getId())
                .name(quiz.getName())
                .date(quiz.getDate())
                .questions(mapQuestions(quiz.getQuizQuestionAnswers()))
                .build();
    }
    private List<QuestionGeneratorDto> mapQuestions(final Set<QuizQuestionAnswer> quizQuestionAnswers) {
        if (CollectionUtils.isEmpty(quizQuestionAnswers)) {
            return List.of();
        }

        return quizQuestionAnswers.stream()
                .map(qqa -> QuestionGeneratorDto.builder()
                        .id(qqa.getQuestionAnswer().getId())
                        .question(qqa.getQuestionAnswer().getQuestion())
                        .answers(mapAnswers(qqa.getQuestionAnswer().getAnswer(), mapDistractorsToString(qqa.getQuestionAnswer().getDistractors())))
                        .selectedAnswer(qqa.getSelectedAnswer())
                        .isCorrect(qqa.getIsCorrect())
                        .build())
                .toList();
    }

    private List<String> mapDistractorsToString(final Set<Distractor> distractors) {
        return distractors.stream().map(Distractor::getDistractor).collect(Collectors.toList());
    }

    private List<String> mapAnswers(final String answer, final List<String> distractors) {
        distractors.add(answer);
        Collections.shuffle(distractors);

        return distractors;
    }

}

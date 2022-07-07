package hr.tvz.hanzekovic.questiongenerator.mapper.impl;

import hr.tvz.hanzekovic.questiongenerator.domain.Distractor;
import hr.tvz.hanzekovic.questiongenerator.domain.QuestionAnswer;
import hr.tvz.hanzekovic.questiongenerator.domain.Quiz;
import hr.tvz.hanzekovic.questiongenerator.dto.QuestionGeneratorDto;
import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.form.QuizForm;
import hr.tvz.hanzekovic.questiongenerator.mapper.QuizMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class QuizMapperImpl implements QuizMapper {

    @Override
    public Quiz toEntity(final QuizForm form) {
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
                .questions(mapQuestions(quiz.getQuestionAnswers()))
                .build();
    }

    private List<QuestionGeneratorDto> mapQuestions(final Set<QuestionAnswer> questionAnswers) {
        if (CollectionUtils.isEmpty(questionAnswers)) {
            return List.of();
        }

        return questionAnswers.stream()
                .map(qa -> QuestionGeneratorDto.builder()
                        .id(qa.getId())
                        .question(qa.getQuestion())
                        .answer(qa.getAnswer())
                        .distractors(qa.getDistractors().stream().map(Distractor::getDistractor).toList())
                        .build())
                .toList();
    }

}

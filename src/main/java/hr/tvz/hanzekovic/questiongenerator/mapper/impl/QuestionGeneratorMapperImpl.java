package hr.tvz.hanzekovic.questiongenerator.mapper.impl;

import hr.tvz.hanzekovic.questiongenerator.domain.Distractor;
import hr.tvz.hanzekovic.questiongenerator.domain.QuestionAnswer;
import hr.tvz.hanzekovic.questiongenerator.dto.QuestionGeneratorDto;
import hr.tvz.hanzekovic.questiongenerator.mapper.QuestionGeneratorMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class QuestionGeneratorMapperImpl implements QuestionGeneratorMapper {

    @Override
    public QuestionGeneratorDto map(final QuestionAnswer questionAnswer, final List<Distractor> distractors) {
        if (Objects.isNull(questionAnswer) || CollectionUtils.isEmpty(distractors)) {
            return null;
        }

        return QuestionGeneratorDto.builder()
                .id(questionAnswer.getId())
                .question(questionAnswer.getQuestion())
                .answers(mapAnswers(questionAnswer.getAnswer(), mapDistractorsToString(distractors)))
                .build();
    }

    private List<String> mapDistractorsToString(final List<Distractor> distractors) {
        return distractors.stream().map(Distractor::getDistractor).collect(Collectors.toList());
    }

    private List<String> mapAnswers(final String answer, final List<String> distractors) {
        distractors.add(answer);
        Collections.shuffle(distractors);

        return distractors;
    }

}

package hr.tvz.hanzekovic.questiongenerator.mapper.impl;

import hr.tvz.hanzekovic.questiongenerator.domain.Distractor;
import hr.tvz.hanzekovic.questiongenerator.domain.QuestionAnswer;
import hr.tvz.hanzekovic.questiongenerator.dto.QuestionGeneratorDto;
import hr.tvz.hanzekovic.questiongenerator.mapper.QuestionGeneratorMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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
                .answer(questionAnswer.getAnswer())
                .distractors(distractors.stream().map(Distractor::getDistractor).collect(Collectors.toList()))
                .build();
    }

}

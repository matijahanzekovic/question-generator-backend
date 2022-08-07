package hr.tvz.hanzekovic.questiongenerator.mapper.impl;

import hr.tvz.hanzekovic.questiongenerator.domain.Distractor;
import hr.tvz.hanzekovic.questiongenerator.domain.QuestionAnswer;
import hr.tvz.hanzekovic.questiongenerator.integration.model.QuestionGeneratorResponse;
import hr.tvz.hanzekovic.questiongenerator.mapper.DistractorMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DistractorMapperImpl implements DistractorMapper {

    @Override
    public List<Distractor> map(final QuestionGeneratorResponse response, final QuestionAnswer questionAnswer) {
        if (Objects.isNull(response) || Objects.isNull(questionAnswer)) {
            return null;
        }

        return response.getDistractors().stream()
                .map(d -> Distractor.builder()
                        .distractor(d)
                        .questionAnswer(questionAnswer)
                        .build())
                .toList();
    }

}

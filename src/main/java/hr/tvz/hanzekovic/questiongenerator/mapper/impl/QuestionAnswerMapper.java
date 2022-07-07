package hr.tvz.hanzekovic.questiongenerator.mapper.impl;

import hr.tvz.hanzekovic.questiongenerator.domain.QuestionAnswer;
import hr.tvz.hanzekovic.questiongenerator.integration.model.QuestionGeneratorResponse;
import hr.tvz.hanzekovic.questiongenerator.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class QuestionAnswerMapper implements Mapper<QuestionAnswer, QuestionGeneratorResponse> {

    @Override
    public QuestionAnswer map(final QuestionGeneratorResponse response) {
        if (Objects.isNull(response)) {
            return null;
        }

        return QuestionAnswer.builder()
                .question(response.getQuestion())
                .answer(response.getAnswer())
                .build();
    }

}

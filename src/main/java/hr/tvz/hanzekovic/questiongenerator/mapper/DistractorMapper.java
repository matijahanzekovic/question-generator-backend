package hr.tvz.hanzekovic.questiongenerator.mapper;

import hr.tvz.hanzekovic.questiongenerator.domain.Distractor;
import hr.tvz.hanzekovic.questiongenerator.domain.QuestionAnswer;
import hr.tvz.hanzekovic.questiongenerator.integration.model.QuestionGeneratorResponse;

import java.util.List;

public interface DistractorMapper {

    List<Distractor> map(QuestionGeneratorResponse response, QuestionAnswer questionAnswer);

}

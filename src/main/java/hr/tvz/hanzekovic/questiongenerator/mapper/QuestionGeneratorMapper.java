package hr.tvz.hanzekovic.questiongenerator.mapper;

import hr.tvz.hanzekovic.questiongenerator.domain.Distractor;
import hr.tvz.hanzekovic.questiongenerator.domain.QuestionAnswer;
import hr.tvz.hanzekovic.questiongenerator.dto.QuestionGeneratorDto;

import java.util.List;

public interface QuestionGeneratorMapper {

    QuestionGeneratorDto map(QuestionAnswer questionAnswer, List<Distractor> distractors);

}

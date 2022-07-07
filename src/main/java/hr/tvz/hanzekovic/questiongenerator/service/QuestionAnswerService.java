package hr.tvz.hanzekovic.questiongenerator.service;

import hr.tvz.hanzekovic.questiongenerator.dto.QuestionGeneratorDto;
import hr.tvz.hanzekovic.questiongenerator.integration.model.QuestionGeneratorResponse;

import java.util.List;

public interface QuestionAnswerService {

    List<QuestionGeneratorDto> save(List<QuestionGeneratorResponse> response);
    void update(Long quizId, List<Long> questionAnswerIds);

}

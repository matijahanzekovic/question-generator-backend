package hr.tvz.hanzekovic.questiongenerator.service;

import hr.tvz.hanzekovic.questiongenerator.integration.model.QuestionGeneratorResponse;

import java.util.List;

public interface DistractorService {

    void save(List<QuestionGeneratorResponse> response);

}

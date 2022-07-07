package hr.tvz.hanzekovic.questiongenerator.integration.service;

import hr.tvz.hanzekovic.questiongenerator.integration.model.QuestionGeneratorResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionGeneratorIntegrationService {

    ResponseEntity<List<QuestionGeneratorResponse>> generate(String text);

}

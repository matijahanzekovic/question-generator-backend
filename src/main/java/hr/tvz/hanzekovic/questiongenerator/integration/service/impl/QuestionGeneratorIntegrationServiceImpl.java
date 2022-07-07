package hr.tvz.hanzekovic.questiongenerator.integration.service.impl;

import hr.tvz.hanzekovic.questiongenerator.integration.model.QuestionGeneratorRequest;
import hr.tvz.hanzekovic.questiongenerator.integration.model.QuestionGeneratorResponse;
import hr.tvz.hanzekovic.questiongenerator.integration.service.QuestionGeneratorIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionGeneratorIntegrationServiceImpl implements QuestionGeneratorIntegrationService {

    @Value("${python.generate-questions.api}")
    private String pythonApiUrl;

    private final RestTemplate restTemplate;

    @Override
    public ResponseEntity<List<QuestionGeneratorResponse>> generate(final String text) {
        final QuestionGeneratorRequest request = QuestionGeneratorRequest.builder()
                .text(text)
                .build();

        final HttpEntity<QuestionGeneratorRequest> requestHttpEntity = new HttpEntity<>(request, createHttpHeaders());

        final ParameterizedTypeReference<List<QuestionGeneratorResponse>> returnType = new ParameterizedTypeReference<>() {};

        return restTemplate.exchange(pythonApiUrl, HttpMethod.POST, requestHttpEntity, returnType);
    }

    private HttpHeaders createHttpHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        return headers;
    }

}

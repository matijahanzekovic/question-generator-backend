package hr.tvz.hanzekovic.questiongenerator.service.impl;

import hr.tvz.hanzekovic.questiongenerator.integration.model.QuestionGeneratorResponse;
import hr.tvz.hanzekovic.questiongenerator.service.DistractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DistractorServiceImpl implements DistractorService {

    @Override
    public void save(final List<QuestionGeneratorResponse> response) {

    }

}

package hr.tvz.hanzekovic.questiongenerator.service.impl;

import hr.tvz.hanzekovic.questiongenerator.domain.Distractor;
import hr.tvz.hanzekovic.questiongenerator.domain.QuestionAnswer;
import hr.tvz.hanzekovic.questiongenerator.dto.QuestionGeneratorDto;
import hr.tvz.hanzekovic.questiongenerator.integration.model.QuestionGeneratorResponse;
import hr.tvz.hanzekovic.questiongenerator.mapper.DistractorMapper;
import hr.tvz.hanzekovic.questiongenerator.mapper.QuestionGeneratorMapper;
import hr.tvz.hanzekovic.questiongenerator.mapper.impl.QuestionAnswerMapper;
import hr.tvz.hanzekovic.questiongenerator.repository.DistractorRepository;
import hr.tvz.hanzekovic.questiongenerator.repository.QuestionAnswerRepository;
import hr.tvz.hanzekovic.questiongenerator.service.QuestionAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

    private final DistractorMapper distractorMapper;
    private final DistractorRepository distractorRepository;
    private final QuestionAnswerMapper questionAnswerMapper;
    private final QuestionAnswerRepository questionAnswerRepository;
    private final QuestionGeneratorMapper questionGeneratorMapper;

    @Override
    @Transactional
    public List<QuestionGeneratorDto> save(final List<QuestionGeneratorResponse> response) {
        if (CollectionUtils.isEmpty(response)) {
            return List.of();
        }

        final List<QuestionGeneratorDto> questionsAndAnswers = new ArrayList<>();

        response.forEach(r -> {
            final QuestionAnswer questionAnswer = questionAnswerRepository.save(questionAnswerMapper.map(r));
            final List<Distractor> distractors = distractorRepository.saveAll(distractorMapper.map(r, questionAnswer));
            final QuestionGeneratorDto dto = questionGeneratorMapper.map(questionAnswer, distractors);
            questionsAndAnswers.add(dto);
        });

        return questionsAndAnswers;
    }

    @Override
    public List<QuestionGeneratorDto> getAllQuestionAnswers() {
        final List<QuestionAnswer> questionsAndAnswers = questionAnswerRepository.getAll();

        return questionsAndAnswers.stream()
                .map(qa -> questionGeneratorMapper.map(qa, qa.getDistractors().stream().toList()))
                .toList();
    }

}

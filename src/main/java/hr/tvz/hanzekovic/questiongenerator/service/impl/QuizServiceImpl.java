package hr.tvz.hanzekovic.questiongenerator.service.impl;

import hr.tvz.hanzekovic.questiongenerator.domain.Quiz;
import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.form.CreateQuizForm;
import hr.tvz.hanzekovic.questiongenerator.mapper.impl.QuizMapperImpl;
import hr.tvz.hanzekovic.questiongenerator.repository.QuizRepository;
import hr.tvz.hanzekovic.questiongenerator.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class QuizServiceImpl implements QuizService {

    private final QuizMapperImpl quizMapper;
    private final QuizRepository quizRepository;

    @Override
    @Transactional
    public Quiz save(final CreateQuizForm form) {
        return quizRepository.saveAndFlush(quizMapper.toEntity(form));
    }

    @Override
    public QuizDto getQuizById(final Long id) {
        final Quiz quiz = quizRepository.findQuizById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Quiz with ID: %d was not found.", id)));

        return quizMapper.toDto(quiz);
    }

}

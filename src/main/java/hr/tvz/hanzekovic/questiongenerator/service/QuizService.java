package hr.tvz.hanzekovic.questiongenerator.service;

import hr.tvz.hanzekovic.questiongenerator.domain.Quiz;
import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.form.QuizForm;

public interface QuizService {

    Quiz save(QuizForm form);
    QuizDto getQuizById(Long id);

}

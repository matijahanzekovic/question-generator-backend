package hr.tvz.hanzekovic.questiongenerator.service;

import hr.tvz.hanzekovic.questiongenerator.domain.Quiz;
import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.form.CreateQuizForm;

public interface QuizService {

    Quiz save(CreateQuizForm form);
    QuizDto getQuizById(Long id);

}

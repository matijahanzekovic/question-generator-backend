package hr.tvz.hanzekovic.questiongenerator.mapper;

import hr.tvz.hanzekovic.questiongenerator.domain.Quiz;
import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.form.QuizForm;

public interface QuizMapper {

    Quiz toEntity(QuizForm form);
    QuizDto toDto(Quiz quiz);

}

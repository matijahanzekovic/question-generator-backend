package hr.tvz.hanzekovic.questiongenerator.mapper;

import hr.tvz.hanzekovic.questiongenerator.domain.Quiz;
import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.form.CreateQuizForm;

public interface QuizMapper {

    Quiz toEntity(CreateQuizForm form);
    QuizDto toDto(Quiz quiz);

}

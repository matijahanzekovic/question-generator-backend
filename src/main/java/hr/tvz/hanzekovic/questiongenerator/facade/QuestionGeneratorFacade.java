package hr.tvz.hanzekovic.questiongenerator.facade;

import hr.tvz.hanzekovic.questiongenerator.dto.QuestionGeneratorDto;
import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.form.QuizForm;

import java.util.List;

public interface QuestionGeneratorFacade {

    List<QuestionGeneratorDto> generateQuestion(String text);
    QuizDto getQuiz(Long id);
    QuizDto createQuiz(QuizForm form);

}

package hr.tvz.hanzekovic.questiongenerator.facade;

import hr.tvz.hanzekovic.questiongenerator.dto.QuestionGeneratorDto;
import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.form.CreateQuizForm;
import hr.tvz.hanzekovic.questiongenerator.form.SolveQuizForm;

import java.util.List;

public interface QuestionGeneratorFacade {

    List<QuestionGeneratorDto> generateQuestions(String text);
    QuizDto getQuiz(Long id);
    QuizDto createQuiz(CreateQuizForm form);
    QuizDto solveQuiz(SolveQuizForm form);
    List<QuestionGeneratorDto> getAllQuestionAnswers();

}

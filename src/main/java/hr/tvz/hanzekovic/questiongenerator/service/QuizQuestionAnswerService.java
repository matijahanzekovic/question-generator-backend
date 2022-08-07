package hr.tvz.hanzekovic.questiongenerator.service;

import hr.tvz.hanzekovic.questiongenerator.dto.QuizDto;
import hr.tvz.hanzekovic.questiongenerator.form.SolveQuizForm;

import java.util.List;

public interface QuizQuestionAnswerService {

    void save(Long quizId, List<Long> questionAnswerIds);
    void solveQuiz(SolveQuizForm form);

}

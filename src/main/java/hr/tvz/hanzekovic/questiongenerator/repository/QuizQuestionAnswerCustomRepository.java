package hr.tvz.hanzekovic.questiongenerator.repository;

import java.util.List;

public interface QuizQuestionAnswerCustomRepository {

    void save(Long quizId, List<Long> questionAnswerIds);

}

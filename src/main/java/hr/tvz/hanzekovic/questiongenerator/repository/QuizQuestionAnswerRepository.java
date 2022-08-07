package hr.tvz.hanzekovic.questiongenerator.repository;

import hr.tvz.hanzekovic.questiongenerator.domain.QuizQuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface QuizQuestionAnswerRepository extends JpaRepository<QuizQuestionAnswer, Long>, QuizQuestionAnswerCustomRepository {

    @Query("""
          SELECT qqa
          FROM QuizQuestionAnswer AS qqa
          LEFT JOIN qqa.quiz AS q
          LEFT JOIN qqa.questionAnswer qa
          WHERE q.id = :quizId
          AND qa.id = :questionAnswerId
    """)
    Optional<QuizQuestionAnswer> getByQuizIdAndQuestionAnswerId(
            @Param("quizId") Long quizId,
            @Param("questionAnswerId") Long questionAnswerId
    );

    @Modifying
    @Query("""
          UPDATE QuizQuestionAnswer AS qqa
          SET qqa.isCorrect = :isCorrect,
              qqa.selectedAnswer = :selectedAnswer
          WHERE qqa.quiz.id = :quizId
          AND qqa.questionAnswer.id = :questionAnswerId
    """)
    void update(
            @Param("quizId") Long quizId,
            @Param("questionAnswerId") Long questionAnswerId,
            @Param("selectedAnswer") String selectedAnswer,
            @Param("isCorrect") boolean isCorrect
    );

}

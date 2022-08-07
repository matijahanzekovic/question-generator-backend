package hr.tvz.hanzekovic.questiongenerator.repository;

import hr.tvz.hanzekovic.questiongenerator.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query("""
          SELECT q
          FROM Quiz AS q
          LEFT JOIN FETCH q.quizQuestionAnswers qqa
          WHERE q.id = :id
          ORDER BY qqa.questionAnswer.id
    """)
    Optional<Quiz> findQuizById(@Param("id") Long id);

}

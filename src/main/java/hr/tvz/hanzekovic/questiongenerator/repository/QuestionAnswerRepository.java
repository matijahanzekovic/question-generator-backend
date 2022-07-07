package hr.tvz.hanzekovic.questiongenerator.repository;

import hr.tvz.hanzekovic.questiongenerator.domain.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = """
          UPDATE question_answer
          SET quiz_id = :quizId
          WHERE id IN (:questionAnswerIds)
    """)
    void update(@Param("quizId") Long quizId, @Param("questionAnswerIds") List<Long> questionAnswerIds);

}

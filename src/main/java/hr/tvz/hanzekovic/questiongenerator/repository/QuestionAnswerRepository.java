package hr.tvz.hanzekovic.questiongenerator.repository;

import hr.tvz.hanzekovic.questiongenerator.domain.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {

    @Query("""
          SELECT DISTINCT(qa)
          FROM QuestionAnswer qa
          LEFT JOIN FETCH qa.distractors d
          ORDER BY qa.id
    """)
    List<QuestionAnswer> getAll();

}

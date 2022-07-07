package hr.tvz.hanzekovic.questiongenerator.repository;

import hr.tvz.hanzekovic.questiongenerator.domain.QuizInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizInfoRepository extends JpaRepository<QuizInfo, Long> {
}

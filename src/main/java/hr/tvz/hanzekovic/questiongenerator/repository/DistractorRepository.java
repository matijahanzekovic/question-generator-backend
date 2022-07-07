package hr.tvz.hanzekovic.questiongenerator.repository;

import hr.tvz.hanzekovic.questiongenerator.domain.Distractor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistractorRepository extends JpaRepository<Distractor, Long> {


}

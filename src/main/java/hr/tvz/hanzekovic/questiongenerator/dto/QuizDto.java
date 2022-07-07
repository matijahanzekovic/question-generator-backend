package hr.tvz.hanzekovic.questiongenerator.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class QuizDto {

    private Long id;
    private String name;
    private LocalDate date;
    private List<QuestionGeneratorDto> questions;

}

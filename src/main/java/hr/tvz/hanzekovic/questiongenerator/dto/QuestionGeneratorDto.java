package hr.tvz.hanzekovic.questiongenerator.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class QuestionGeneratorDto {

    private Long id;
    private String question;
    private List<String> answers;
    private String correctAnswer;
    private String selectedAnswer;
    private Boolean isCorrect;

}

package hr.tvz.hanzekovic.questiongenerator.integration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class QuestionGeneratorResponse {

    private String question;
    private String answer;
    private List<String> distractors;

}

package hr.tvz.hanzekovic.questiongenerator.integration.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class QuestionGeneratorRequest {

    private String text;

}

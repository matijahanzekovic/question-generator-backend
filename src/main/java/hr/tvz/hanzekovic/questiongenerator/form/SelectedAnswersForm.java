package hr.tvz.hanzekovic.questiongenerator.form;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SelectedAnswersForm {

    private Long id;
    private String answer;

}

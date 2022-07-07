package hr.tvz.hanzekovic.questiongenerator.form;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class QuizForm {

    private String name;
    private List<Long> questionAnswerIds;

}

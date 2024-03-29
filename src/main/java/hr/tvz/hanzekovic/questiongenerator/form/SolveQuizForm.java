package hr.tvz.hanzekovic.questiongenerator.form;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class SolveQuizForm {

    private Long quizId;
    private List<SelectedAnswersForm> selectedAnswers;

}

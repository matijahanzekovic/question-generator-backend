package hr.tvz.hanzekovic.questiongenerator.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "quiz_question_answer")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class QuizQuestionAnswer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_answer_id")
    private QuestionAnswer questionAnswer;

    @Column(name = "selected_answer", length = 500)
    private String selectedAnswer;

    @Column(name = "is_correct")
    private Boolean isCorrect;

}

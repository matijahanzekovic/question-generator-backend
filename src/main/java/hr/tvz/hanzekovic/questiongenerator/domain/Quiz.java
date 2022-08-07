package hr.tvz.hanzekovic.questiongenerator.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "quiz")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "name", length = 500)
    private String name;

    @Column(name = "date")
    private LocalDate date;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "quiz_question_answer",
            joinColumns = { @JoinColumn(name = "quiz_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "question_answer_id", referencedColumnName = "id") }
    )
    private Set<QuestionAnswer> questionAnswers;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY)
    private Set<QuizQuestionAnswer> quizQuestionAnswers;

}

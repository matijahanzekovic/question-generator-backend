package hr.tvz.hanzekovic.questiongenerator.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "question_answer")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class QuestionAnswer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "question", length = 1000)
    private String question;

    @Column(name = "answer", length = 500)
    private String answer;

    @OneToMany(mappedBy = "questionAnswer", fetch = FetchType.LAZY)
    private Set<Distractor> distractors;

}

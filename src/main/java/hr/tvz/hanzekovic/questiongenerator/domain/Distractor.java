package hr.tvz.hanzekovic.questiongenerator.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "distractor")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Distractor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "distractor", length = 500)
    private String distractor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_answer_id")
    private QuestionAnswer questionAnswer;

}

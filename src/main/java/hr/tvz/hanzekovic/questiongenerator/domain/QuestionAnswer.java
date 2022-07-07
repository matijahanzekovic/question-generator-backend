package hr.tvz.hanzekovic.questiongenerator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "question_answer")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

}

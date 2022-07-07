package hr.tvz.hanzekovic.questiongenerator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "quiz")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
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

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY)
    private Set<QuestionAnswer> questionAnswers;

}

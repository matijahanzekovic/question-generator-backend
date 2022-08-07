package hr.tvz.hanzekovic.questiongenerator.repository.impl;

import hr.tvz.hanzekovic.questiongenerator.repository.QuizQuestionAnswerCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class QuizQuestionAnswerCustomRepositoryImpl implements QuizQuestionAnswerCustomRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(final Long quizId, final List<Long> questionAnswerIds) {
        final String query = """
                                INSERT INTO quiz_question_answer (quiz_id, question_answer_id)
                                VALUES (?, ?)
                             """;

        jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1, quizId);
                ps.setLong(2, questionAnswerIds.get(i));
            }

            @Override
            public int getBatchSize() {
                return questionAnswerIds.size();
            }
        });
    }

}

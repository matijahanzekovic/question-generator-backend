package hr.tvz.hanzekovic.questiongenerator.service.impl;

import hr.tvz.hanzekovic.questiongenerator.domain.QuizQuestionAnswer;
import hr.tvz.hanzekovic.questiongenerator.form.SolveQuizForm;
import hr.tvz.hanzekovic.questiongenerator.repository.QuizQuestionAnswerRepository;
import hr.tvz.hanzekovic.questiongenerator.service.QuizQuestionAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuizQuestionAnswerServiceImpl implements QuizQuestionAnswerService {

    private final QuizQuestionAnswerRepository quizQuestionAnswerRepository;

    @Override
    @Transactional
    public void save(final Long quizId, final List<Long> questionAnswerIds) {
        quizQuestionAnswerRepository.save(quizId, questionAnswerIds);
    }

    @Override
    @Transactional
    public void solveQuiz(final SolveQuizForm form) {
        form.getSelectedAnswers().forEach(sa -> {
            final QuizQuestionAnswer quizQuestionAnswer = quizQuestionAnswerRepository
                    .getByQuizIdAndQuestionAnswerId(form.getQuizId(), sa.getId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            String.format("Quiz question answer for quizId: %d and questionAnswerId: %d was not found",
                                    form.getQuizId(), sa.getId())));

            final boolean isCorrect = quizQuestionAnswer.getQuestionAnswer().getAnswer().equals(sa.getAnswer());
            quizQuestionAnswerRepository.update(form.getQuizId(), sa.getId(), sa.getAnswer(), isCorrect);
        });

//        form.getSelectedAnswers().forEach((id, answer) -> {
//            final QuizQuestionAnswer quizQuestionAnswer = quizQuestionAnswerRepository
//                    .getByQuizIdAndQuestionAnswerId(form.getQuizId(), id)
//                    .orElseThrow(() -> new EntityNotFoundException(
//                            String.format("Quiz question answer for quizId: %d and questionAnswerId: %d was not found",
//                                    form.getQuizId(), id)));
//
//            final boolean isCorrect = quizQuestionAnswer.getQuestionAnswer().getAnswer().equals(answer);
//            quizQuestionAnswerRepository.update(form.getQuizId(), id, answer, isCorrect);
//        });
    }

}

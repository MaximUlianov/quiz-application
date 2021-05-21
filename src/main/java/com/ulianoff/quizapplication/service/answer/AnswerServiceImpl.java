package com.ulianoff.quizapplication.service.answer;

import com.ulianoff.quizapplication.dao.AnswerRepository;
import com.ulianoff.quizapplication.model.domain.Answer;
import com.ulianoff.quizapplication.model.domain.Question;
import com.ulianoff.quizapplication.model.dto.quiz.AnswerDto;
import com.ulianoff.quizapplication.service.converter.AnswerConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    private final AnswerConverter converter;

    @Override
    public AnswerDto createAnswer(AnswerDto answerDto) {

        Answer answer = converter.answerDtoToAnswer(answerDto);

        Question question = new Question();
        question.setId(Long.parseLong(answerDto.getQuestionId()));

        answer.setQuestion(question);
        answerRepository.save(answer);

        answerDto.setId(String.valueOf(answer.getId()));

        return answerDto;
    }
}

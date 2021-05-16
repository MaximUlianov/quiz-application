package com.ulianoff.quizapplication.service.answer;

import com.ulianoff.quizapplication.dao.AnswerRepository;
import com.ulianoff.quizapplication.model.domain.Answer;
import com.ulianoff.quizapplication.model.domain.Question;
import com.ulianoff.quizapplication.model.dto.AnswerDto;
import com.ulianoff.quizapplication.service.answer.AnswerService;
import com.ulianoff.quizapplication.service.converter.AnswerConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    private final AnswerConverter converter;

    @Override
    public AnswerDto save(AnswerDto answerDto) {

        Answer answer = converter.answerDtoToAnswer(answerDto);

        Question question = new Question();
        question.setId(Long.parseLong(answerDto.getQuestionId()));

        answer.setQuestion(question);
        answerRepository.save(answer);

        answerDto.setId(String.valueOf(answer.getId()));

        return answerDto;
    }

    @Override
    public AnswerDto getById(String id) {
        return null;
    }

    @Override
    public List<AnswerDto> getAll() {
        return null;
    }

    @Override
    public boolean delete(AnswerDto entity) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }
}

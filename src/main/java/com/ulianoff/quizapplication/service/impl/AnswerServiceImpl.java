package com.ulianoff.quizapplication.service.impl;

import com.ulianoff.quizapplication.dao.AnswerRepository;
import com.ulianoff.quizapplication.model.domain.Answer;
import com.ulianoff.quizapplication.model.domain.Question;
import com.ulianoff.quizapplication.model.dto.AnswerDto;
import com.ulianoff.quizapplication.service.AnswerService;
import com.ulianoff.quizapplication.service.converter.AnswerConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository repository;

    private final AnswerConverter converter;

    @Override
    public AnswerDto add(AnswerDto answerDto) {

        Answer answer = converter.answerDtoToAnswer(answerDto);

        Question question = new Question();
        question.setId(Long.parseLong(answerDto.getQuestionId()));

        answer.setQuestion(question);
        repository.save(answer);

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

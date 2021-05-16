package com.ulianoff.quizapplication.service.quiz;

import com.ulianoff.quizapplication.dao.QuizRepository;
import com.ulianoff.quizapplication.model.domain.Quiz;
import com.ulianoff.quizapplication.model.dto.QuizDto;
import com.ulianoff.quizapplication.service.converter.QuizConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository repository;

    private final QuizConverter converter;

    @Override
    public QuizDto save(QuizDto quizDto) {
        Quiz quiz = converter.quizDtoToQuiz(quizDto);
        quiz.setQuestions(null);
        repository.save(quiz);
        quizDto.setId(String.valueOf(quiz.getId()));
        return quizDto;
    }

    @Override
    public QuizDto getById(String id) {
        return converter.quizToQuizDto(repository.findById(Long.parseLong(id)).orElse(null));
    }

    @Override
    public List<QuizDto> getAll() {
        return null;
    }

    @Override
    public boolean delete(QuizDto entity) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }
}

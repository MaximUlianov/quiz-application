package com.ulianoff.quizapplication.service.quiz;

import com.ulianoff.quizapplication.dao.QuizRepository;
import com.ulianoff.quizapplication.model.domain.Quiz;
import com.ulianoff.quizapplication.model.domain.User;
import com.ulianoff.quizapplication.model.dto.quiz.QuizDto;
import com.ulianoff.quizapplication.service.converter.QuizConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository repository;

    private final QuizConverter converter;

    @Override
    public QuizDto createQuiz(QuizDto quizDto) {

        Quiz quiz = converter.quizDtoToQuiz(quizDto);
        quiz.setQuestions(null);

        User user = new User();
        user.setId(Long.parseLong(quizDto.getUserCreatorId()));
        quiz.setUser(user);

        repository.save(quiz);
        quizDto.setId(String.valueOf(quiz.getId()));

        return quizDto;
    }

    @Override
    public QuizDto getQuizById(String id) {

        return converter.quizToQuizDto(repository.findById(Long.parseLong(id)).orElse(null));
    }

    @Override
    public List<QuizDto> getAllQuiz() {

        return repository.findAll()
                .stream()
                .map(converter::quizToQuizDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuizDto> getAllQuizByCreatorId(String creatorId) {

        return repository.findAllByUser_Id(Long.parseLong(creatorId))
                .stream()
                .map(converter::quizToQuizDto)
                .collect(Collectors.toList());
    }
}

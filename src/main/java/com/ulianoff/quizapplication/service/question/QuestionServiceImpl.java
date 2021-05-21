package com.ulianoff.quizapplication.service.question;

import com.ulianoff.quizapplication.dao.QuestionRepository;
import com.ulianoff.quizapplication.model.domain.Question;
import com.ulianoff.quizapplication.model.domain.Quiz;
import com.ulianoff.quizapplication.model.dto.quiz.QuestionDto;
import com.ulianoff.quizapplication.service.converter.QuestionConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;

    private final QuestionConverter converter;

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {

        Question question = converter.questionDtoToQuestion(questionDto);

        Quiz quiz = new Quiz();
        quiz.setId(Long.parseLong(questionDto.getQuizId()));

        question.setQuiz(quiz);
        repository.save(question);
        questionDto.setId(String.valueOf(question.getId()));

        return questionDto;
    }
}

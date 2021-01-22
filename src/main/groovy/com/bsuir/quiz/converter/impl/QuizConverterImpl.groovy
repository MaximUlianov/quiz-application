package com.bsuir.quiz.converter.impl

import com.bsuir.quiz.converter.ModelConverter
import com.bsuir.quiz.dto.QuestionDto
import com.bsuir.quiz.dto.QuizDto
import com.bsuir.quiz.model.Question
import com.bsuir.quiz.model.Quiz
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class QuizConverterImpl implements ModelConverter<Quiz, QuizDto> {

    private ModelConverter questionConverter;

    @Autowired
    QuizConverterImpl(@Qualifier("questionConverterImpl") ModelConverter questionConverter) {
        this.questionConverter = questionConverter
    }

    @Override
    Quiz convertFromDto(QuizDto dto) {
        Quiz quiz = new Quiz()
        quiz.id = dto.id
        quiz.title = dto.title
        quiz.questions = dto.questions.collect { questionConverter.convertFromDto(it) } as Set<Question>
        quiz
    }

    @Override
    QuizDto convertToDto(Quiz entity) {
        QuizDto dto = new QuizDto();
        dto.id = entity.id
        dto.title = entity.title
        dto.questions = entity.questions.collect {questionConverter.convertToDto(it)} as Set<QuestionDto>
        dto
    }
}

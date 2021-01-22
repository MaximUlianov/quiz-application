package com.bsuir.quiz.converter.impl

import com.bsuir.quiz.converter.ModelConverter
import com.bsuir.quiz.dto.AnswerDto
import com.bsuir.quiz.dto.QuestionDto
import com.bsuir.quiz.model.Answer
import com.bsuir.quiz.model.Question
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class QuestionConverterImpl implements ModelConverter<Question, QuestionDto> {

    private ModelConverter answerConverter;

    @Autowired
    QuestionConverterImpl(@Qualifier("answerConverterImpl") ModelConverter answerConverter) {
        this.answerConverter = answerConverter
    }

    @Override
    Question convertFromDto(QuestionDto dto) {
        Question question = new Question()
        question.id = dto.id
        question.title = dto.title
        question.answers = dto.answers.collect { answerConverter.convertFromDto(it) } as Set<Answer>
        question
    }

    @Override
    QuestionDto convertToDto(Question entity) {
        QuestionDto dto = new QuestionDto()
        dto.id = entity.id
        dto.title = entity.title
        dto.answers = entity.answers.collect {answerConverter.convertToDto(it)} as Set<AnswerDto>
        dto
    }
}

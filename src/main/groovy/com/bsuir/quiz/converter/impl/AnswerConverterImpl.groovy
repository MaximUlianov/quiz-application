package com.bsuir.quiz.converter.impl

import com.bsuir.quiz.converter.ModelConverter
import com.bsuir.quiz.dto.AnswerDto
import com.bsuir.quiz.model.Answer
import org.springframework.stereotype.Component;

@Component
class AnswerConverterImpl implements ModelConverter<Answer, AnswerDto> {

    @Override
    Answer convertFromDto(AnswerDto dto) {
        Answer answer = new Answer()
        answer.id = dto.id
        answer.text = dto.text
        answer
    }

    @Override
    AnswerDto convertToDto(Answer entity) {
        AnswerDto dto = new AnswerDto()
        dto.id = entity.id
        dto.text = entity.text
        dto
    }
}

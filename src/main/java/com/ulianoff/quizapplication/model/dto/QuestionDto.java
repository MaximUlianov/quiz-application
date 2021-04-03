package com.ulianoff.quizapplication.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class QuestionDto implements Serializable {

    private Long id;

    private String title;

    private Set<AnswerDto> answers;
}

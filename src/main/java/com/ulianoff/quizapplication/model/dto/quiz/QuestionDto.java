package com.ulianoff.quizapplication.model.dto.quiz;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class QuestionDto implements Serializable {

    private String id;

    private String title;

    private String quizId;

    private Set<AnswerDto> answers;
}

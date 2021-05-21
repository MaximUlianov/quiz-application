package com.ulianoff.quizapplication.model.dto.quiz;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnswerDto implements Serializable {

    private String id;

    private String questionId;

    private String text;

    private Boolean correct;
}

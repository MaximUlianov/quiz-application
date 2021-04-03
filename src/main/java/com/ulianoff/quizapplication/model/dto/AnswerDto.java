package com.ulianoff.quizapplication.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnswerDto implements Serializable {

    private Long id;

    private String text;
}

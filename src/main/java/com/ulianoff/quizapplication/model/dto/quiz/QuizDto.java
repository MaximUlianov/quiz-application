package com.ulianoff.quizapplication.model.dto.quiz;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class QuizDto implements Serializable {

    private String id;

    private String title;

    private Set<QuestionDto> questions;

    private String userCreatorId;
}

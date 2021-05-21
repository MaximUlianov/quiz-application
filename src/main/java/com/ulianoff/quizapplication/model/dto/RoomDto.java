package com.ulianoff.quizapplication.model.dto;

import com.ulianoff.quizapplication.model.dto.quiz.QuizDto;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class RoomDto {

    private String id;

    @NotNull
    private String name;

    @Min(1)
    @Max(10)
    private Integer capacity;

    private String code;

    private boolean privateRoom;

    private String userId;

    private String quizId;

    private QuizDto quiz;

    private Set<UserDto> users;
}

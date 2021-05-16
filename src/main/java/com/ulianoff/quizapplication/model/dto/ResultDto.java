package com.ulianoff.quizapplication.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ResultDto {

    private String username;

    private Integer points;
}

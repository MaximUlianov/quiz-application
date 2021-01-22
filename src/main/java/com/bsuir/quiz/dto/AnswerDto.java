package com.bsuir.quiz.dto;

import com.bsuir.quiz.model.Answer;

import java.io.Serializable;

public class AnswerDto implements Serializable {
    private Long id;
    private String text;

    public AnswerDto(Answer answer) {
        this.id = answer.getId();
        this.text = answer.getText();
    }

    public AnswerDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

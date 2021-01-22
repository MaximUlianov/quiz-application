package com.bsuir.quiz.dto;

import com.bsuir.quiz.model.Question;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestionDto implements Serializable {
    private Long id;
    private String title;
    private Set<AnswerDto> answers;

    public QuestionDto(Question question) {
        this.id = question.getId();
        this.title = question.getTitle();
        this.answers = question.getAnswers().stream().map(AnswerDto::new).collect(Collectors.toUnmodifiableSet());
    }

    public QuestionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<AnswerDto> answers) {
        this.answers = answers;
    }
}

package com.bsuir.quiz.dto;

import com.bsuir.quiz.model.Quiz;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
public class QuizDto implements Serializable {

    private Long id;
    private String title;
    private Set<QuestionDto> questions;

    public QuizDto(Quiz quiz) {
        this.id = quiz.getId();
        this.title = quiz.getTitle();
        this.questions = quiz.getQuestions().stream().map(QuestionDto::new).collect(Collectors.toUnmodifiableSet());
    }

    public QuizDto() {
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

    public Set<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionDto> questions) {
        this.questions = questions;
    }
}

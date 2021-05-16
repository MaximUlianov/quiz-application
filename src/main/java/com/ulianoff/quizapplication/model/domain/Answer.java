package com.ulianoff.quizapplication.model.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "answer", schema = "public")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "correct_answer")
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}

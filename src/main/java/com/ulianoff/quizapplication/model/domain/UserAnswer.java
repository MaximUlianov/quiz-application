package com.ulianoff.quizapplication.model.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_answer", schema = "public")
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_session_id")
    private GameSession gameSession;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;
}

package com.ulianoff.quizapplication.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "game", schema = "public")
public class GameSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_timestamp")
    private LocalDateTime startTimestamp;

    @Column(name = "end_timestamp")
    private LocalDateTime endTimestamp;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}

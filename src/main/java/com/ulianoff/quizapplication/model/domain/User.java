package com.ulianoff.quizapplication.model.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}

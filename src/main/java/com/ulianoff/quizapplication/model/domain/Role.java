package com.ulianoff.quizapplication.model.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "role", schema = "public")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String name;
}

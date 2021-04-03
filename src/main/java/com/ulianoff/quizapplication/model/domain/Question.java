package com.ulianoff.quizapplication.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "question", schema = "public")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private Set<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "questions")
    private Set<Category> categories;
}

package com.ulianoff.quizapplication.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "room", schema = "public")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "private")
    private boolean privateRoom;

    @Column(name = "code")
    private String code;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "room_user",
            joinColumns = {@JoinColumn(name = "room_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<User> users = new HashSet<>();
}

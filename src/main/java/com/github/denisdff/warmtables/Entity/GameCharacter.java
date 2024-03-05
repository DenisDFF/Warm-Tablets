package com.github.denisdff.warmtables.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "game_character")
@Data
public class GameCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "game_id")
    private Long gameId;

    private String name;

    private String description;

    private String source;
}

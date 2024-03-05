package com.github.denisdff.warmtables.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "game_rules")
@Data
public class GameRules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "game_id")
    private Long gameId;

    private String name;

    private String description;

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}

package com.github.denisdff.warmtables.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "favorites")
@Data
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private GameRules gameRules;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private GameItem gameItem;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private GameEquipment gameEquipment;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private GameCharacter gameCharacter;
}

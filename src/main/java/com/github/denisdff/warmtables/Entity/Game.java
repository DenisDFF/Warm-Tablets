package com.github.denisdff.warmtables.Entity;

import jakarta.persistence.*;
import lombok.Data;


import javax.swing.plaf.basic.BasicIconFactory;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "games")
@Data
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;
    private String BigImageUrl;
    private String name;
    private String description;
    private String link;

    @ElementCollection
    @CollectionTable(name = "game_details", joinColumns = @JoinColumn(name = "game_id"))
    @Column(name = "name")
    private List<String> details;

    public Game() {
    }
}

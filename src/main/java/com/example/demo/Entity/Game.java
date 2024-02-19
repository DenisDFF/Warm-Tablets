package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;


import javax.swing.plaf.basic.BasicIconFactory;
import java.util.List;

@Entity
@Table(name = "games")
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;
    private String BigImageUrl;
    private String name;
    private String description;
    private String link;
    private String[] categories;

    public Game() {
    }
}

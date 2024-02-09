package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;
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
    private List<String> categories;

    public Game() {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.imageUrl = imageUrl;
//        this.categories = categories;
//        this.BigImageUrl = BigImageUrl;
    }
}

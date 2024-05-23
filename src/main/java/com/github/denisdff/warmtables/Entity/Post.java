package com.github.denisdff.warmtables.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "posts")
@Data
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String name;

    private String description;

    private String base64;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();
}

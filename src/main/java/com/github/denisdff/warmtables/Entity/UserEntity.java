package com.github.denisdff.warmtables.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

//    @Enumerated(EnumType.STRING)
//    private UserRole role;

    @Column(nullable = false)
    private boolean enabled;
}

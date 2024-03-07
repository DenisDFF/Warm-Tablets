package com.github.denisdff.warmtables.Entity;

import com.github.denisdff.warmtables.Config.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

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

package com.github.denisdff.warmtables.Repository;

import com.github.denisdff.warmtables.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByName(String name);
}
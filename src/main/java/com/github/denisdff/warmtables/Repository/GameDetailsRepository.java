package com.github.denisdff.warmtables.Repository;


import com.github.denisdff.warmtables.Entity.Game;
import com.github.denisdff.warmtables.Entity.GameRules;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameDetailsRepository extends JpaRepository<GameRules, Long> {
    List<GameRules> findByGameId(Long gameId);
}

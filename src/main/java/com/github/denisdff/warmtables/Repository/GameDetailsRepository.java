package com.github.denisdff.warmtables.Repository;

import com.github.denisdff.warmtables.Entity.Game;
import com.github.denisdff.warmtables.Entity.GameRules;
import com.github.denisdff.warmtables.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameDetailsRepository extends JpaRepository<GameRules, Long> {
    List<GameRules> findByGameId(Long gameId);

    @Query("SELECT r FROM GameRules r WHERE r.gameId = :gameId AND LOWER(r.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<GameRules> findByGameIdFiltered(Long gameId,@Param("query") String query);
}

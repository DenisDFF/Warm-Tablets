package com.github.denisdff.warmtables.Repository;

import com.github.denisdff.warmtables.Entity.GameCharacter;
import com.github.denisdff.warmtables.Entity.GameRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameCharacterRepository extends JpaRepository<GameCharacter, Long> {
    List<GameCharacter> findByGameId(Long gameId);

    @Query("SELECT r FROM GameCharacter r WHERE r.gameId = :gameId AND LOWER(r.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<GameCharacter> findByGameIdFiltered(Long gameId, @Param("query") String query);
}

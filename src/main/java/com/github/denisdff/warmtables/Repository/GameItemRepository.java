package com.github.denisdff.warmtables.Repository;

import com.github.denisdff.warmtables.Entity.GameItem;
import com.github.denisdff.warmtables.Entity.GameRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameItemRepository extends JpaRepository<GameItem, Long> {
    List<GameItem> findByGameId(Long gameId);

    @Query("SELECT i FROM GameItem i WHERE i.gameId = :gameId AND i.name LIKE %:query%")
    List<GameItem> findByGameIdFiltered(Long gameId, @Param("query") String query);
}

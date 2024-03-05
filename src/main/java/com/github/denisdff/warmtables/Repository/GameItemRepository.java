package com.github.denisdff.warmtables.Repository;

import com.github.denisdff.warmtables.Entity.GameItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameItemRepository extends JpaRepository<GameItem, Long> {
    List<GameItem> findByGameId(Long gameId);
}

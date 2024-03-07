package com.github.denisdff.warmtables.Dao;

import com.github.denisdff.warmtables.Entity.GameItem;
import com.github.denisdff.warmtables.Entity.GameRules;
import com.github.denisdff.warmtables.Repository.GameItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GameItemDao {
    private final GameItemRepository gameItemRepository;

    @Autowired
    public GameItemDao(GameItemRepository gameItemRepository) {
        this.gameItemRepository = gameItemRepository;
    }

    public List<GameItem> findByGameId(Long gameId) {
        return gameItemRepository.findByGameId(gameId);
    }

    public List<GameItem> findByGameIdFiltered(Long gameId, String query) {
        return gameItemRepository.findByGameIdFiltered(gameId, query);
    }

    public GameItem saveItem(GameItem gameItem) {
        return gameItemRepository.save(gameItem);
    }
}
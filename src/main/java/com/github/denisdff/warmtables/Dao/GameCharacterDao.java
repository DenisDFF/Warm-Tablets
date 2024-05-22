package com.github.denisdff.warmtables.Dao;


import com.github.denisdff.warmtables.Entity.GameCharacter;
import com.github.denisdff.warmtables.Entity.GameRules;
import com.github.denisdff.warmtables.Repository.GameCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameCharacterDao {
    private final GameCharacterRepository gameCharacterRepository;

    @Autowired
    public GameCharacterDao (GameCharacterRepository gameCharacterRepository) {
        this.gameCharacterRepository = gameCharacterRepository;
    }

    @Cacheable(value = "character", key = "'gameId'")
    public List<GameCharacter> findByGameId(Long gameId) {
        return gameCharacterRepository.findByGameId(gameId);
    }

    public List<GameCharacter> findByGameIdFiltered(Long gameId, String query) {
        return gameCharacterRepository.findByGameIdFiltered(gameId, query);
    }

    public GameCharacter saveItem(GameCharacter item) {
        return gameCharacterRepository.save(item);
    }
}

package com.github.denisdff.warmtables.Dao;

import com.github.denisdff.warmtables.Entity.Game;
import com.github.denisdff.warmtables.Entity.GameRules;
import com.github.denisdff.warmtables.Repository.GameDetailsRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameDetailsDao {
    private final GameDetailsRepository gameDetailsRepository;

    @Autowired
    public GameDetailsDao(GameDetailsRepository gameDetailsRepository) {
        this.gameDetailsRepository = gameDetailsRepository;
    }

    @Cacheable(value = "rules", key = "'gameId'")
    public List<GameRules> findByGameId(Long gameId) {
        return gameDetailsRepository.findByGameId(gameId);
    }

    public List<GameRules> findByGameIdFiltered(Long gameId, String query) {
        return gameDetailsRepository.findByGameIdFiltered(gameId, query);
    }

    public GameRules saveItem(GameRules gameRules) {
       return gameDetailsRepository.save(gameRules);
    }
}
package com.example.demo.Dao;

import com.example.demo.Entity.GameItem;
import com.example.demo.Entity.GameRules;
import com.example.demo.Repository.GameDetailsRepository;
import com.example.demo.Repository.GameItemRepository;
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
}
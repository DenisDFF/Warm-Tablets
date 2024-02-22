package com.example.demo.Dao;

import com.example.demo.Entity.GameRules;
import com.example.demo.Repository.GameDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameDetailsDao {
    private final GameDetailsRepository gameDetailsRepository;

    @Autowired
    public GameDetailsDao(GameDetailsRepository gameDetailsRepository) {
        this.gameDetailsRepository = gameDetailsRepository;
    }

    public List<GameRules> findByGameId(Long gameId) {
        return gameDetailsRepository.findByGameId(gameId);
    }
}
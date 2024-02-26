package com.example.demo.Dao;


import com.example.demo.Entity.GameCharacter;
import com.example.demo.Entity.GameRules;
import com.example.demo.Repository.GameCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameCharacterDao {
    private final GameCharacterRepository gameCharacterRepository;

    @Autowired
    public GameCharacterDao (GameCharacterRepository gameCharacterRepository) {
        this.gameCharacterRepository = gameCharacterRepository;
    }

    public List<GameCharacter> findByGameId(Long gameId) {
        return gameCharacterRepository.findByGameId(gameId);
    }
}

package com.github.denisdff.warmtables.Dao;

import com.github.denisdff.warmtables.Entity.Game;
import com.github.denisdff.warmtables.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GameDao {

    private final GameRepository gameRepository;

    @Autowired
    public GameDao(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game findByName(String name) {
        return gameRepository.findByName(name);
    }

    public Game saveGame(Game game) {
       return gameRepository.save(game);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }


}

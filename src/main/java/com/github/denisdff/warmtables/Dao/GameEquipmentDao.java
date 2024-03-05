package com.github.denisdff.warmtables.Dao;

import com.github.denisdff.warmtables.Entity.GameEquipment;
import com.github.denisdff.warmtables.Repository.GameEquipmentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameEquipmentDao {
    public final GameEquipmentRepository gameEquipmentRepository;

    public GameEquipmentDao (GameEquipmentRepository gameEquipmentRepository) {
        this.gameEquipmentRepository = gameEquipmentRepository;
    }

    public List<GameEquipment> findByGameId(Long gameId) {
        return gameEquipmentRepository.findByGameId(gameId);
    }

    public GameEquipment saveItem(GameEquipment item) {
       return gameEquipmentRepository.save(item);
    }
}

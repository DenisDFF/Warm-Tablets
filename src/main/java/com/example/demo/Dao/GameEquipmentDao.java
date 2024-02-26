package com.example.demo.Dao;

import com.example.demo.Entity.GameEquipment;
import com.example.demo.Entity.GameItem;
import com.example.demo.Repository.GameEquipmentRepository;
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
}

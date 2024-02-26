package com.example.demo.Repository;

import com.example.demo.Entity.GameEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameEquipmentRepository extends JpaRepository<GameEquipment, Long> {
    List<GameEquipment> findByGameId(Long gameId);
}

package com.github.denisdff.warmtables.Repository;

import com.github.denisdff.warmtables.Entity.GameEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameEquipmentRepository extends JpaRepository<GameEquipment, Long> {
    List<GameEquipment> findByGameId(Long gameId);
}

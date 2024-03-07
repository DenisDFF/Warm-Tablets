package com.github.denisdff.warmtables.Repository;

import com.github.denisdff.warmtables.Entity.GameEquipment;
import com.github.denisdff.warmtables.Entity.GameRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameEquipmentRepository extends JpaRepository<GameEquipment, Long> {
    List<GameEquipment> findByGameId(Long gameId);

    @Query("SELECT r FROM GameEquipment r WHERE r.gameId = :gameId AND r.name LIKE %:query%")
    List<GameEquipment> findByGameIdFiltered(Long gameId, @Param("query") String query);
}

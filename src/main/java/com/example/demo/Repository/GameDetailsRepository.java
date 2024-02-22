package com.example.demo.Repository;


import com.example.demo.Entity.GameRules;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameDetailsRepository extends JpaRepository<GameRules, Long> {
    List<GameRules> findByGameId(Long gameId);
}

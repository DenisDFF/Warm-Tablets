package com.example.demo.Repository;

import com.example.demo.Entity.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameCharacterRepository extends JpaRepository<GameCharacter, Long> {
    List<GameCharacter> findByGameId(Long gameId);
}

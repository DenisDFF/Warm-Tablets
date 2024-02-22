package com.example.demo.Repository;

import com.example.demo.Entity.GameItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameItemRepository extends JpaRepository<GameItem, Long> {
    List<GameItem> findByGameId(Long gameId);
}

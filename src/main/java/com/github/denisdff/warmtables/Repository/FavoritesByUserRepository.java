package com.github.denisdff.warmtables.Repository;

import com.github.denisdff.warmtables.Entity.Favorite;
import com.github.denisdff.warmtables.Entity.GameRules;
import com.github.denisdff.warmtables.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesByUserRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUser(UserEntity userEntity);
    void deleteByUserAndGameRulesId(UserEntity user, Long gameRulesId);
    void deleteByUserAndGameItemId(UserEntity user, Long gameItemId);
    void deleteByUserAndGameCharacterId(UserEntity user, Long gameCharacterId);
    void deleteByUserAndGameEquipmentId(UserEntity user, Long gameEquipmentId);
}

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
}

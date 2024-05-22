package com.github.denisdff.warmtables.Repository;

import com.github.denisdff.warmtables.Entity.Game;
import com.github.denisdff.warmtables.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {
    Post findByName(String name);
}

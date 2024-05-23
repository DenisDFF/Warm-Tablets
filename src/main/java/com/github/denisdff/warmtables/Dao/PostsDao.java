package com.github.denisdff.warmtables.Dao;

import com.github.denisdff.warmtables.Entity.Game;
import com.github.denisdff.warmtables.Entity.Post;
import com.github.denisdff.warmtables.Repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostsDao {

    private final PostsRepository postsRepository;

    @Autowired
    public PostsDao (PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public List<Post> getAllPosts() {
        return postsRepository.findAll();
    }

    @Cacheable(value = "game", key = "allPost")
    public List<Post> findAllByOrderByCreatedDateDesc() {
        return postsRepository.findAllByOrderByCreatedDateDesc();
    }

    public Post findByName(String name) {
        return postsRepository.findByName(name);
    }

    public Post savePost(Post post) {
        return postsRepository.save(post);
    }

    public void deletePost(Long id) {
        postsRepository.deleteById(id);
    }
}

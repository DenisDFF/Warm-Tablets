package com.github.denisdff.warmtables.Controller;

import com.github.denisdff.warmtables.Dao.PostsDao;
import com.github.denisdff.warmtables.Dao.UserDao;
import com.github.denisdff.warmtables.Entity.Post;
import com.github.denisdff.warmtables.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class PostController {
    private final PostsDao postsDao;
    private final UserDao userDao;

    public PostController (PostsDao postsDao, UserDao userDao) {
        this.postsDao = postsDao;
        this.userDao = userDao;
    }

    @RequestMapping("/posts")
    public String postsSite(Model model) {
        List<Post> posts = postsDao.getAllPosts();
        List<UserEntity> users = userDao.findAll();


        Map<Long, UserEntity> userMap = users.stream().collect(Collectors.toMap(UserEntity::getId, user -> user));

        model.addAttribute("posts", posts);
        model.addAttribute("userMap", userMap);

        return "postSite";
    }

}

package com.github.denisdff.warmtables.Controller;

import com.github.denisdff.warmtables.Dao.PostsDao;
import com.github.denisdff.warmtables.Dao.UserDao;
import com.github.denisdff.warmtables.Entity.Post;
import com.github.denisdff.warmtables.Entity.UserEntity;
import com.github.denisdff.warmtables.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class PostController {
    private final PostsDao postsDao;
    private final UserDao userDao;

    private final UserRepository userRepository;

    public PostController (PostsDao postsDao, UserDao userDao, UserRepository userRepository) {
        this.postsDao = postsDao;
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    @RequestMapping("/posts")
    public String postsSite(Model model) {
        List<Post> posts = postsDao.findAllByOrderByCreatedDateDesc();
        List<UserEntity> users = userDao.findAll();


        Map<Long, UserEntity> userMap = users.stream().collect(Collectors.toMap(UserEntity::getId, user -> user));

        model.addAttribute("posts", posts);
        model.addAttribute("userMap", userMap);

        return "postSite";
    }

    @PostMapping("/post-create")
    public String addPost(@RequestParam("name") String name,
                          @RequestParam("description") String description,
                          @RequestParam("image") MultipartFile image,
                          Authentication authentication,
                          Model model) throws IOException {
        Post post = new Post();
        post.setName(name);
        post.setDescription(description);

        if (!image.isEmpty()) {
            byte[] imageBytes = image.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            post.setBase64(base64Image);
        }

        String username = authentication.getName();
        UserEntity currentUser = userRepository.findByUsername(username);

        post.setUserId(currentUser.getId());

        postsDao.savePost(post);
        return "redirect:/posts";
    }

}

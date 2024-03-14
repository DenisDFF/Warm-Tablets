package com.github.denisdff.warmtables.Controller;

import com.github.denisdff.warmtables.Repository.GameDetailsRepository;
import com.github.denisdff.warmtables.Repository.GameRepository;
import com.github.denisdff.warmtables.Dao.*;
import com.github.denisdff.warmtables.Entity.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private final GameDao gameDao;
    private final GameDetailsDao gameDetailsDao;
    private final GameRepository gameRepository;

    private final GameItemDao gameItemDao;

    private final GameCharacterDao gameCharacterDao;
    private final GameEquipmentDao gameEquipmentDao;

    private final GameDetailsRepository gameDetailsRepository;

    private final UserDao userDao;

    public MainController(GameDao gameDao, GameDetailsDao gameDetailsDao, GameRepository gameRepository, GameItemDao gameItemDao, GameCharacterDao gameCharacterDao, GameEquipmentDao gameEquipmentDao,
                          GameDetailsRepository gameDetailsRepository, UserDao userDao) {
        this.gameDao = gameDao;
        this.gameDetailsDao = gameDetailsDao;
        this.gameRepository = gameRepository;
        this.gameItemDao = gameItemDao;
        this.gameCharacterDao = gameCharacterDao;
        this.gameEquipmentDao = gameEquipmentDao;
        this.gameDetailsRepository = gameDetailsRepository;
        this.userDao = userDao;
          }

    @RequestMapping("/login")
    public String showLoginForm() {
        return "authorizationSite";
    }

    @GetMapping("/logout")
    public String logout() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }

     @RequestMapping("/create-user")
     public String createUser (Model model) {
        model.addAttribute("user", new UserEntity());
        return "createUser";
     }

    @PostMapping("/createUser")
    public String createUserSubmit (@ModelAttribute UserEntity user, Model model) {
        user.setEnabled(true);
        UserEntity addedUser = userDao.save(user);
        model.addAttribute("addedUser", addedUser);
        return "redirect:/";
    }

    @RequestMapping("/games-catalog")
    public String catalogGameSite (Model model) {

        List<Game> games = gameDao.getAllGames();

        model.addAttribute("games", games);

        return "gamesCatalog";
    }

    @RequestMapping("/game/{name}")
    public String gameSite(@PathVariable String name, Model model) {
        Game game = gameRepository.findByName(name);
        if (game != null) {
            model.addAttribute("game", game);
        }
        return "siteTemplates";
    }

    @RequestMapping("/info")
    public String infoPage() {
        return "infoSite";
    }

    @RequestMapping("/friends")
    public String friendsPage() {
        return "frendsSite";
    }

    @RequestMapping("/infoGame")
    public String infoGamePage() {
        return "infoGame";
    }

    @RequestMapping("/")
    public String homePage() {
        return "mainsite";
    }

}

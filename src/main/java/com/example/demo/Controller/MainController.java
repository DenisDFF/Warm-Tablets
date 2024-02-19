package com.example.demo.Controller;

import com.example.demo.Dao.GameDao;
import com.example.demo.Entity.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    private final GameDao gameDao;

    public MainController(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @RequestMapping("/games-catalog")
    public String testGameSite (Model model) {

        List<Game> games = gameDao.getAllGames();

        model.addAttribute("games", games);

        return "gamesCatalog";
    }

    @RequestMapping("/game/{name}")
    public String gameDetails(@PathVariable String name, Model model) {
        Game game = gameDao.findByName(name);
        model.addAttribute("game", game);
        return "siteTemplates";
    }

//
//    @RequestMapping("/category/{category}")
//    public String showCategory(@PathVariable String category, Model model) {
//        List<Game> gamesInCategory = new ArrayList<>();
//        for (Game game : games) {
//            if (game.getCategories().contains(category)) {
//                gamesInCategory.add(game);
//            }
//        }
//        model.addAttribute("category", category);
//        model.addAttribute("gamesInCategory", gamesInCategory);
//        return "categoryTemplates";
//    }
//
    @RequestMapping("/")
    public String homePage() {
        return "mainsite";
    }

}

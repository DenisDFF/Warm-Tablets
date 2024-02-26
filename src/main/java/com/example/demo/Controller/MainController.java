package com.example.demo.Controller;

import com.example.demo.Dao.*;
import com.example.demo.Entity.*;
import com.example.demo.Repository.GameRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    private final GameDao gameDao;
    private final GameDetailsDao gameDetailsDao;
    private final GameRepository gameRepository;

    private final GameItemDao gameItemDao;

    private final GameCharacterDao gameCharacterDao;
    private final GameEquipmentDao gameEquipmentDao;

    public MainController(GameDao gameDao, GameDetailsDao gameDetailsDao, GameRepository gameRepository, GameItemDao gameItemDao, GameCharacterDao gameCharacterDao, GameEquipmentDao gameEquipmentDao) {
        this.gameDao = gameDao;
        this.gameDetailsDao = gameDetailsDao;
        this.gameRepository = gameRepository;
        this.gameItemDao = gameItemDao;
        this.gameCharacterDao = gameCharacterDao;
        this.gameEquipmentDao = gameEquipmentDao;
          }

    @RequestMapping("/games-catalog")
    public String testGameSite (Model model) {

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

    @RequestMapping("/game/{name}/Правила")
    public String gameDetailsRules(@PathVariable("name") String name, Model model) {
        String gameName = name.replace("/Правила", "");
        Game game = gameRepository.findByName(gameName);
        if (game != null) {
            List<GameRules> gameRules = gameDetailsDao.findByGameId(game.getId());
            model.addAttribute("game", game);
            model.addAttribute("gameDetails", gameRules);
        }
        return "categoryTemplates";
    }

    @RequestMapping("/game/{name}/Предмети")
    public String gameDetailsItem(@PathVariable("name") String name, Model model) {
        String gameName = name.replace("/Предмети", "");
        Game game = gameRepository.findByName(gameName);
        if (game != null) {
            List<GameItem> gameItems = gameItemDao.findByGameId(game.getId());
            model.addAttribute("game", game);
            model.addAttribute("gameDetails", gameItems);
        }
        return "categoryTemplates";
    }

    @RequestMapping("/game/{name}/Персонажи")
    public String gameDetailsCharacter(@PathVariable("name") String name, Model model) {
        String gameName = name.replace("/Персонажи", "");
        Game game = gameRepository.findByName(gameName);
        if (game != null) {
            List<GameCharacter> gameCharacters = gameCharacterDao.findByGameId(game.getId());
            model.addAttribute("game", game);
            model.addAttribute("gameDetails", gameCharacters);
        }
        return "categoryTemplatesWithSource";
    }

    @RequestMapping("/game/{name}/Спорядження")
    public String gameDetailsEquipment(@PathVariable("name") String name, Model model) {
        String gameName = name.replace("/Спорядження", "");
        Game game = gameRepository.findByName(gameName);
        if (game != null) {
            List<GameEquipment> gameEquipment = gameEquipmentDao.findByGameId(game.getId());
            model.addAttribute("game", game);
            model.addAttribute("gameDetails", gameEquipment);
        }
        return "categoryTemplatesWithSource";
    }

    @RequestMapping("/")
    public String homePage() {
        return "mainsite";
    }

}

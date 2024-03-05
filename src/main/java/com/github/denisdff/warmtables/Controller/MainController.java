package com.github.denisdff.warmtables.Controller;

import com.github.denisdff.warmtables.Repository.GameDetailsRepository;
import com.github.denisdff.warmtables.Repository.GameRepository;
import com.github.denisdff.warmtables.Dao.*;
import com.github.denisdff.warmtables.Entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    public MainController(GameDao gameDao, GameDetailsDao gameDetailsDao, GameRepository gameRepository, GameItemDao gameItemDao, GameCharacterDao gameCharacterDao, GameEquipmentDao gameEquipmentDao,
                          GameDetailsRepository gameDetailsRepository) {
        this.gameDao = gameDao;
        this.gameDetailsDao = gameDetailsDao;
        this.gameRepository = gameRepository;
        this.gameItemDao = gameItemDao;
        this.gameCharacterDao = gameCharacterDao;
        this.gameEquipmentDao = gameEquipmentDao;
        this.gameDetailsRepository = gameDetailsRepository;
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

    @RequestMapping("/game/{name}/Rules")
    public String gameDetailsRules(@PathVariable("name") String name, Model model) {
        String gameName = name.replace("/Rules", "");
        Game game = gameRepository.findByName(gameName);
        if (game != null) {
            List<GameRules> gameRules = gameDetailsDao.findByGameId(game.getId());
            model.addAttribute("game", game);
            model.addAttribute("gameDetails", gameRules);
        }
        return "categoryTemplatesRules";
    }

    @GetMapping("/create/{name}/Rules")
    public String createRules(@PathVariable("name") String name, Model model) {
        String gameName = name.replace("/Rules", "");
        Game game = gameRepository.findByName(gameName);
        model.addAttribute("game", game);
        model.addAttribute("gameRules", new GameRules());
        return "createNewRules";
    }

    @PostMapping("/createRules")
    public String createRulesSubmit(@ModelAttribute GameRules gameRules, Model model) {
        GameRules addedGameRules = gameDetailsDao.saveItem(gameRules);
        model.addAttribute("addedGameRules", addedGameRules);
        return "redirect:/games-catalog";
    }

    @RequestMapping("/game/{name}/Items")
    public String gameDetailsItem(@PathVariable("name") String name, Model model) {
        String gameName = name.replace("/Items", "");
        Game game = gameRepository.findByName(gameName);
        if (game != null) {
            List<GameItem> gameItems = gameItemDao.findByGameId(game.getId());
            model.addAttribute("game", game);
            model.addAttribute("gameDetails", gameItems);
        }
        return "categoryTemplatesItem";
    }

    @GetMapping("/create/{name}/Item")
    public String createItem(@PathVariable("name") String name, Model model) {
        String gameName = name.replace("/Item", "");
        Game game = gameRepository.findByName(gameName);
        model.addAttribute("game", game);
        model.addAttribute("gameItem", new GameItem());
        return "createNewItem";
    }

    @PostMapping("/createItem")
    public String createItemSubmit(@ModelAttribute GameItem gameItem, Model model) {
        GameItem addedGameItem = gameItemDao.saveItem(gameItem);
        model.addAttribute("addedGameItem", addedGameItem);
        return "redirect:/games-catalog";
    }


    @RequestMapping("/game/{name}/Character")
    public String gameDetailsCharacter(@PathVariable("name") String name, Model model) {
        String gameName = name.replace("/Character", "");
        Game game = gameRepository.findByName(gameName);
        if (game != null) {
            List<GameCharacter> gameCharacters = gameCharacterDao.findByGameId(game.getId());
            model.addAttribute("game", game);
            model.addAttribute("gameDetails", gameCharacters);
        }
        return "categoryTemplatesCharacter";
    }

    @GetMapping("/create/{name}/Character")
    public String createCharacter(@PathVariable("name") String name, Model model) {
        String gameName = name.replace("/Character", "");
        Game game = gameRepository.findByName(gameName);
        model.addAttribute("game", game);
        model.addAttribute("gameCharacter", new GameCharacter());
        return "createNewCharacter";
    }

    @PostMapping("/createCharacter")
    public String createCharacterSubmit(@ModelAttribute GameCharacter gameCharacter, Model model) {
        GameCharacter addedGameCharacter = gameCharacterDao.saveItem(gameCharacter);
        model.addAttribute("addedGameCharacter", addedGameCharacter);
        return "redirect:/games-catalog";
    }

    @RequestMapping("/game/{name}/Equipment")
    public String gameDetailsEquipment(@PathVariable("name") String name, Model model) {
        String gameName = name.replace("/Equipment", "");
        Game game = gameRepository.findByName(gameName);
        if (game != null) {
            List<GameEquipment> gameEquipment = gameEquipmentDao.findByGameId(game.getId());
            model.addAttribute("game", game);
            model.addAttribute("gameDetails", gameEquipment);
        }
        return "categoryTemplatesEquipment";
    }

    @GetMapping("/create/{name}/Equipment")
    public String createEquipment(@PathVariable("name") String name, Model model) {
        String gameName = name.replace("/Equipment", "");
        Game game = gameRepository.findByName(gameName);
        model.addAttribute("game", game);
        model.addAttribute("gameEquipment", new GameEquipment());
        return "createNewEquipment";
    }

    @PostMapping("/createEquipment")
    public String createEquipmentSubmit(@ModelAttribute GameEquipment gameEquipment, Model model) {
        GameEquipment addedGameEquipment = gameEquipmentDao.saveItem(gameEquipment);
        model.addAttribute("addedGameEquipment", addedGameEquipment);
        return "redirect:/games-catalog";
    }

    @RequestMapping("/info")
    public String infoPage() {
        return "infoSite";
    }

    @RequestMapping("/")
    public String homePage() {
        return "mainsite";
    }

}

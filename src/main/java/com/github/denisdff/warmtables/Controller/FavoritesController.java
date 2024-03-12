package com.github.denisdff.warmtables.Controller;

import com.github.denisdff.warmtables.Entity.*;
import com.github.denisdff.warmtables.Repository.FavoritesByUserRepository;
import com.github.denisdff.warmtables.Repository.GameDetailsRepository;
import com.github.denisdff.warmtables.Repository.GameItemRepository;
import com.github.denisdff.warmtables.Repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FavoritesController {

    private UserRepository userRepository;
    private GameDetailsRepository gameDetailsRepository;

    private FavoritesByUserRepository favoritesByUserRepository;

    private GameItemRepository gameItemRepository;
    public FavoritesController(UserRepository userRepository, GameDetailsRepository gameDetailsRepository, FavoritesByUserRepository favoritesByUserRepository,
                                GameItemRepository gameItemRepository) {
        this.userRepository = userRepository;
        this.gameDetailsRepository = gameDetailsRepository;
        this.favoritesByUserRepository = favoritesByUserRepository;
        this.gameItemRepository = gameItemRepository;
    }

    @RequestMapping("/favorites")
    public String favoritePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        UserEntity currentUser = userRepository.findByUsername(username);

        List<Favorite> favorites = favoritesByUserRepository.findByUser(currentUser);
        List<GameRules> gameRulesList = new ArrayList<>();
        List<GameItem> gameItemList = new ArrayList<>();
        List<GameEquipment> gameEquipList = new ArrayList<>();
        List<GameCharacter> gameCharList = new ArrayList<>();

        for (Favorite favorite : favorites) {
            GameRules gameRules = favorite.getGameRules();
            GameCharacter gameCharacter = favorite.getGameCharacter();
            GameItem gameItem = favorite.getGameItem();
            GameEquipment gameEquipment = favorite.getGameEquipment();
            gameRulesList.add(gameRules);
            gameCharList.add(gameCharacter);
            gameItemList.add(gameItem);
            gameEquipList.add(gameEquipment);
        }
        model.addAttribute("gameRules", gameRulesList);
        model.addAttribute("gameItem", gameItemList);
        model.addAttribute("gameEquip", gameEquipList);
        model.addAttribute("gameChar", gameCharList);
        return "favorite";
    }

    @GetMapping("/favoriteCreate")
    public void favoriteCreate(@ModelAttribute Favorite favorite, @RequestParam Long ruleId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        UserEntity currentUser = userRepository.findByUsername(username);

        GameRules gameRule = gameDetailsRepository.findById(ruleId).orElse(null);

        if (gameRule != null) {
            favorite.setUser(currentUser);
            favorite.setGameRules(gameRule);

            favoritesByUserRepository.save(favorite);
        }

        GameItem gameItem = gameItemRepository.findById(ruleId).orElse(null);

        if (gameItem != null) {
            favorite.setUser(currentUser);
            favorite.setGameItem(gameItem);

            favoritesByUserRepository.save(favorite);
        }

    }
}

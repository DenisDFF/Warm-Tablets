package com.github.denisdff.warmtables.Controller;

import com.github.denisdff.warmtables.Entity.*;
import com.github.denisdff.warmtables.Repository.*;
import jakarta.transaction.Transactional;
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

    private GameEquipmentRepository gameEquipmentRepository;

    private GameCharacterRepository gameCharacterRepository;

    public FavoritesController(UserRepository userRepository, GameDetailsRepository gameDetailsRepository, FavoritesByUserRepository favoritesByUserRepository,
                                GameItemRepository gameItemRepository, GameEquipmentRepository gameEquipmentRepository, GameCharacterRepository gameCharacterRepository) {
        this.userRepository = userRepository;
        this.gameDetailsRepository = gameDetailsRepository;
        this.favoritesByUserRepository = favoritesByUserRepository;
        this.gameItemRepository = gameItemRepository;
        this.gameEquipmentRepository = gameEquipmentRepository;
        this.gameCharacterRepository = gameCharacterRepository;
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

//    @GetMapping("/favoriteCreate")
//    public String favoriteCreate(@ModelAttribute Favorite favorite, @RequestParam Long ruleId, Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        String username = authentication.getName();
//        UserEntity currentUser = userRepository.findByUsername(username);
//
//        GameRules gameRule = gameDetailsRepository.findById(ruleId).orElse(null);
//
//        if (gameRule != null) {
//            favorite.setUser(currentUser);
//            favorite.setGameRules(gameRule);
//
//            favoritesByUserRepository.save(favorite);
//        }
//
//        GameItem gameItem = gameItemRepository.findById(ruleId).orElse(null);
//
//        if (gameItem != null) {
//            favorite.setUser(currentUser);
//            favorite.setGameItem(gameItem);
//
//            favoritesByUserRepository.save(favorite);
//        }
//
//        GameEquipment gameEquipment = gameEquipmentRepository.findById(ruleId).orElse(null);
//
//        if (gameItem != null) {
//            favorite.setUser(currentUser);
//            favorite.setGameEquipment(gameEquipment);
//
//            favoritesByUserRepository.save(favorite);
//        }
//
//        GameCharacter gameCharacter = gameCharacterRepository.findById(ruleId).orElse(null);
//
//        if (gameItem != null) {
//            favorite.setUser(currentUser);
//            favorite.setGameCharacter(gameCharacter);
//
//            favoritesByUserRepository.save(favorite);
//        }
//        return "redirect:/favorites";
//    }

    @GetMapping("/favoriteCreateRule")
    public String favoriteCreateRule(@ModelAttribute Favorite favorite, @RequestParam Long ruleId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        UserEntity currentUser = userRepository.findByUsername(username);

        GameRules gameRule = gameDetailsRepository.findById(ruleId).orElse(null);

        if (gameRule != null) {
            favorite.setUser(currentUser);
            favorite.setGameRules(gameRule);

            favoritesByUserRepository.save(favorite);
        }

        return "redirect:/favorites";
    }

    @GetMapping("/favoriteCreateItem")
    public String favoriteCreateItem(@ModelAttribute Favorite favorite, @RequestParam Long ruleId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        UserEntity currentUser = userRepository.findByUsername(username);

        GameItem gameItem = gameItemRepository.findById(ruleId).orElse(null);

        if (gameItem != null) {
            favorite.setUser(currentUser);
            favorite.setGameItem(gameItem);

            favoritesByUserRepository.save(favorite);
        }

        return "redirect:/favorites";
    }

    @GetMapping("/favoriteCreateEquip")
    public String favoriteCreateEquip(@ModelAttribute Favorite favorite, @RequestParam Long ruleId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        UserEntity currentUser = userRepository.findByUsername(username);

        GameEquipment gameEquipment = gameEquipmentRepository.findById(ruleId).orElse(null);

        if (gameEquipment != null) {
            favorite.setUser(currentUser);
            favorite.setGameEquipment(gameEquipment);

            favoritesByUserRepository.save(favorite);
        }

        return "redirect:/favorites";
    }

    @GetMapping("/favoriteCreateChar")
    public String favoriteCreateChar(@ModelAttribute Favorite favorite, @RequestParam Long ruleId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        UserEntity currentUser = userRepository.findByUsername(username);

        GameCharacter gameCharacter = gameCharacterRepository.findById(ruleId).orElse(null);

        if (gameCharacter != null) {
            favorite.setUser(currentUser);
            favorite.setGameCharacter(gameCharacter);

            favoritesByUserRepository.save(favorite);
        }

        return "redirect:/favorites";
    }

    @Transactional
    @GetMapping("/favoriteDeleteRules")
    public String favoriteDeleteRule(@RequestParam Long favoriteId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        UserEntity currentUser = userRepository.findByUsername(username);

        favoritesByUserRepository.deleteByUserAndGameRulesId(currentUser, favoriteId);
        return "redirect:/favorites";
    }

    @Transactional
    @GetMapping("/favoriteDeleteItem")
    public String favoriteDeleteItem(@RequestParam Long favoriteId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        UserEntity currentUser = userRepository.findByUsername(username);

        favoritesByUserRepository.deleteByUserAndGameItemId(currentUser, favoriteId);
        return "redirect:/favorites";
    }

    @Transactional
    @GetMapping("/favoriteDeleteEquip")
    public String favoriteDeleteEquip(@RequestParam Long favoriteId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        UserEntity currentUser = userRepository.findByUsername(username);

        favoritesByUserRepository.deleteByUserAndGameEquipmentId(currentUser, favoriteId);
        return "redirect:/favorites";
    }

    @Transactional
    @GetMapping("/favoriteDeleteChar")
    public String favoriteDeleteChar(@RequestParam Long favoriteId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        UserEntity currentUser = userRepository.findByUsername(username);

        favoritesByUserRepository.deleteByUserAndGameCharacterId(currentUser, favoriteId);
        return "redirect:/favorites";
    }
}

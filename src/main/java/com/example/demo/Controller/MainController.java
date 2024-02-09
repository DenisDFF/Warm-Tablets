package com.example.demo.Controller;

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

    List<Game> games = new ArrayList<>();

    @RequestMapping("/games-catalog")
    public String testGameSite (Model model) {

        Game game1 = new Game();
        game1.setImageUrl("/static/images/Hgwarts.png");
        game1.setBigImageUrl("/static/images/BigArtHogwarts.png");
        game1.setName("Гоґвортс НРГ");
        game1.setLink("https://drive.google.com/file/d/1oHWk77AKFZpPCCApyMnKZ-reYLVWEOHL/view");
        game1.setDescription("Ласкаво просимо до Гоґвортсу! Ви збираєтеся сплести історію про таємниці, дружбу, небезпеку та магію. Цей посібник навчить вас грати в гру, ознайомивши вас з усім для першої сесії. Посібник достатньо прочитати тільки одному гравцю та Оповідачу. Усі інші можуть вчитися на їх грі. Давайте почнемо!");
        List<String> categories = Arrays.asList("Злиднi", "Правила");
        game1.setCategories(categories);

        Game game2 = new Game();
        game2.setImageUrl("/static/images/Arkandia.png");
        game2.setBigImageUrl("/static/images/BigArtArkandia.png");
        game2.setName("Чарівні Лавки Аркандії");
        game2.setLink("https://drive.google.com/file/d/1e3wEBHOs8lSXxFBZMxt_MtvrShJYsyel/view?usp=sharing");
        game2.setDescription("Дорогі пригодники та майстри магії, ви чудово знаєте як іноді важко бути героями, віддавати своє життя заради світового порятунку та стикатися з безперервними загрозами. А що як ви вже втомилися від цього безперервного втручання в справи всесвіту та мрієте про щось більш затишне та спокійне? Тоді ви потрапили саме туди, куди потрібно!");
        List<String> categories2 = Arrays.asList("Заклинання", "Правила", "Правила", "Правила", "Правила", "Правила", "Правила", "Правила");
        game2.setCategories(categories2);


        games.add(game1);
        games.add(game2);

        model.addAttribute("games", games);

        return "gamesCatalog";
    }

    @RequestMapping("/game/{name}")
    public String gameDetails(@PathVariable String name, Model model) {
        Game game = games.stream()
                .filter(g -> g.getName().equals(name))
                .findFirst()
                .orElse(null);
        model.addAttribute("game", game);
        System.out.println(name);
        return "siteTemplates";
    }

    @RequestMapping("/category/{category}")
    public String showCategory(@PathVariable String category, Model model) {
        List<Game> gamesInCategory = new ArrayList<>();
        for (Game game : games) {
            if (game.getCategories().contains(category)) {
                gamesInCategory.add(game);
            }
        }
        model.addAttribute("category", category); // Передаем выбранную категорию в модель
        model.addAttribute("gamesInCategory", gamesInCategory); // Передаем список игр в данной категории
        return "categoryTemplates"; // Возвращаем имя шаблона для отображения категории
    }

    @RequestMapping("/")
    public String homePage() {
        return "mainsite";
    }

}

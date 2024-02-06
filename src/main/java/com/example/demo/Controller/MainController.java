package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping("/")
    public String homePage() {
        return "mainsite";
    }

    @RequestMapping("/games-catalog")
    public String gamesCatalog() {
        return "gamesCatalog";
    }

    @RequestMapping("/hogwarts-site")
    public String hogwartsSite() {
        return "hogwartsSite";
    }

    @RequestMapping("/arkandia-site")
    public String arkandiaSite() {
        return "arkandiaSite";
    }
}

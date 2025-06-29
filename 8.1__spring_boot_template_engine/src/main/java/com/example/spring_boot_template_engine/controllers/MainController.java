package com.example.spring_boot_template_engine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(Model page) {
        page.addAttribute("animal", "Cat");
        page.addAttribute("name", "Billu");
        page.addAttribute("color", "orange");
        return "home.html";
    }
}

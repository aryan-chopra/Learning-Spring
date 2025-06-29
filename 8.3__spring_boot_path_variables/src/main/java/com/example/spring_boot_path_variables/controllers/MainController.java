package com.example.spring_boot_path_variables.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/home/{color}")
    public String home(@PathVariable String color,
                       Model page) {
        page.addAttribute("animal", "Cat");
        page.addAttribute("name", "Billu");
        page.addAttribute("color", color);
        return "home.html";
    }
}

package com.example.web_scopes.controller;

import com.example.web_scopes.service.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.NativeDetector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class LoginController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private LoginProcessor loginProcessor;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/")
    public String loinGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        logger.info(loginProcessor.toString());

        boolean isLoggedIn = loginProcessor.login();

        String message;
        if (isLoggedIn) {
            return "redirect:/main";
        } else {
            message = "Incorrect credentials";
        }

        model.addAttribute("message", message);
        return "login.html";
    }
}

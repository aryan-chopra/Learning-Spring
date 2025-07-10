package com.example.web_scopes.controller;

import com.example.web_scopes.service.LoggedUserManagementService;
import com.example.web_scopes.service.LoginCounterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCounterService loginCounterService;

    public MainController(
            LoggedUserManagementService loggedUserManagementService,
            LoginCounterService loginCounterService
    ) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCounterService = loginCounterService;
    }

    @GetMapping("/main")
    public String home(
            @RequestParam(required = false) String logout,
            Model model
    ) {
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        String username = loggedUserManagementService.getUsername();

        if (username == null) {
            return "redirect:/";
        } else {
            int count = loginCounterService.getCounter();

            model.addAttribute("id", loggedUserManagementService.toString());
            model.addAttribute("counter", count);
            model.addAttribute("username", username);
            return "main.html";
        }
    }
}

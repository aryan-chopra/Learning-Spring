package com.example.rest_endpoints.controller;

import com.example.rest_endpoints.error.MissingPlayerNameException;
import com.example.rest_endpoints.model.ErrorDetails;
import com.example.rest_endpoints.model.Player;
import com.example.rest_endpoints.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/boss")
    public Player boss() {
        Player player = Player.of("Boss", 500);

        return player;
    }

    @GetMapping("/team")
    public List<Player> team() {
        Player player1 = Player.of("Raju", 80);
        Player player2 = Player.of("Shyam", 70);
        Player player3 = Player.of("Babu Rao", 100);

        return List.of(player1, player2, player3);
    }

    @GetMapping("/don")
    public ResponseEntity<Player> don() {
        Player player = Player.of("Don", 600);

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("name", "Don")
                .header("health", "600")
                .body(player);
    }

    @PostMapping("/new")
    public ResponseEntity<?> newPlayer() {
        try {
            Player player = playerService.addPlayer();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(player);
        } catch (MissingPlayerNameException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("No name specified!");
            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }
}

package com.example.rest_endpoints.service;

import com.example.rest_endpoints.error.MissingPlayerNameException;
import com.example.rest_endpoints.model.Player;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    public Player addPlayer() {
        throw new MissingPlayerNameException();
    }
}

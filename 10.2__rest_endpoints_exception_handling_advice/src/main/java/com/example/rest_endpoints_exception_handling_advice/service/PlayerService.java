package com.example.rest_endpoints_exception_handling_advice.service;

import com.example.rest_endpoints_exception_handling_advice.error.MissingPlayerNameException;
import com.example.rest_endpoints_exception_handling_advice.model.Player;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    public Player addPlayer() {
        throw new MissingPlayerNameException();
    }
}

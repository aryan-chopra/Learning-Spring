package com.example.rest_endpoints_request_body.service;

import com.example.rest_endpoints_request_body.error.MissingPlayerNameException;
import com.example.rest_endpoints_request_body.model.NewPlayerDetails;
import com.example.rest_endpoints_request_body.model.Player;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PlayerService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public Player addPlayer(NewPlayerDetails newPlayerDetails) {
        if (newPlayerDetails.getName() == null || newPlayerDetails.getName().isEmpty()) {
            throw new MissingPlayerNameException();
        } else {
            logger.info("Name: " + newPlayerDetails.getName());
            return Player.of(newPlayerDetails.getName(), 100);
        }
    }
}

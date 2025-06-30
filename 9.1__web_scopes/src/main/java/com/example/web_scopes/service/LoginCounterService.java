package com.example.web_scopes.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCounterService {

    private int counter;

    public void increment() {
        ++this.counter;
    }

    public int getCounter() {
        return this.counter;
    }
}

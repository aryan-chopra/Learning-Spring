package com.example.rest_endpoints.model;

public class Player {

    private String name;
    private int health;

    public static Player of(String name, int health) {
        Player player = new Player();
        player.name = name;
        player.health = health;
        return player;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

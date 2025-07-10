package main;

import org.springframework.stereotype.Component;

@Component
public class Demon {
    private String name = "Betaal";

    public Demon() {
        System.out.println("Demon created!");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}

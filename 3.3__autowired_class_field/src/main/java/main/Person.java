package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Vikram";

    @Autowired
    private Demon demon;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDemon(Demon demon) {
        this.demon = demon;
    }

    public Demon getDemon() {
        return this.demon;
    }
}

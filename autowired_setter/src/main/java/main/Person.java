package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Vikram";
    private Demon demon;

    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    public void setDemon(Demon demon) {
        this.demon = demon;
    }

    public String getName() {
        return this.name;
    }

    public Demon getDemon() {
        return this.demon;
    }
}

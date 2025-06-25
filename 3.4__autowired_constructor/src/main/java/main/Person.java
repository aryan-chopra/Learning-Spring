package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Vikram";

    private final Demon demon;

    @Autowired
    public Person(Demon demon) {
        this.demon = demon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Demon getDemon() {
        return this.demon;
    }
}

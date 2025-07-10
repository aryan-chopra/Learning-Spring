package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Vikram";

    private final Demon demon;

    public Person(@Qualifier("demon2") Demon demon) {
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

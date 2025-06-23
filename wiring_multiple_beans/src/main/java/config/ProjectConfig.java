package config;

import main.Demon;
import main.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Demon demon1() {
        Demon demon = new Demon();
        demon.setName("Betaal");
        return demon;
    }

    @Bean Demon demon2() {
        Demon demon = new Demon();
        demon.setName("Shaitaan");
        return demon;
    }

    @Bean
    public Person person(Demon demon2) {
        Person person = new Person();
        person.setName("Vikram");

        //Wiring
        person.setDemon(demon2);

        return person;
    }
}

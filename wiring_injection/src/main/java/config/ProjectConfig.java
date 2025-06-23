package config;

import main.Demon;
import main.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Demon demon() {
        Demon demon = new Demon();
        demon.setName("Betaal");
        return demon;
    }

    @Bean
    public Person person(Demon demon) {
        Person person = new Person();
        person.setName("Vikram");

        //Wiring through injection
        person.setDemon(demon);

        return person;
    }
}

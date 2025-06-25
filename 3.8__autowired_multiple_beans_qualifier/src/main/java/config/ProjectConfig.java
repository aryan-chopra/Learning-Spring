package config;

import main.Demon;
import main.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "main")
public class ProjectConfig {
    @Bean
    public Demon demon1() {
        Demon demon = new Demon();
        demon.setName("Betaal");
        return demon;
    }

    @Bean
    public Demon demon2() {
        Demon demon = new Demon();
        demon.setName("Shaitaan");
        return demon;
    }
}

package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
//        Demon demon = context.getBean(Demon.class);

        System.out.println("Person: " + person.getName());
//        System.out.println("Demon: " + demon.getName());
        System.out.println(("Demon stuck to person: " + person.getDemon()));
    }
}

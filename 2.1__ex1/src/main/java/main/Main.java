package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean(Parrot.class);
        Parrot parrot1 = context.getBean(Parrot.class);

        Parrot parrot2 = new Parrot();
        parrot2.setName("Koko");

        if (parrot == parrot1) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }

        System.out.println(parrot.getName());
    }
}

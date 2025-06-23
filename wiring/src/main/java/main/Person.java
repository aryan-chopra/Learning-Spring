package main;

public class Person {
    private String name;
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

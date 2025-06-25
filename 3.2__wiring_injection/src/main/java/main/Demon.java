package main;

public class Demon {
    private String name;

    public Demon() {
        System.out.println("Demon created!");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}

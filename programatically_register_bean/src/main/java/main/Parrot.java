package main;

public class Parrot {
    private String name;
    private boolean isEvil;

    public void setEvil(boolean isEvil) {
        this.isEvil = isEvil;
    }

    public boolean isEvil() {
        return this.isEvil;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

package Lesezeichen;

public class Lesezeichen {
    int x;
    int y;
    String name;

    public Lesezeichen(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


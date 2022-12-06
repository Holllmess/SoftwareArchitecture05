package Seminar05;

public class Texture implements Entity{
    private static int counter = 50000;
    private int id;
    {
        id = ++counter;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Texture #%s", id);
    }
}

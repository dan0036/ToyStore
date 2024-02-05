package model;

public class toy {
    public int id;
    public String title;
    public int quantity;
    public int frequency;
    private static int lastId = 0;

    public toy(int id, String title, int quantity, int frequency) {
    }

    public toy(String title, int quantity, int frequency) {
        this.id = lastId + 1;
        this.title = title;
        this.quantity = quantity;
        this.frequency = frequency;
    }

}

package model;

public class toy {
    public int id;
    public String title;
    public int quantity;
    public int frequency;
    private static int lastId;

    public toy(Object o, Object object, Object o1, Object object1) {
    }

    public toy(String title, int quantity, int frequency) {
        this.id = lastId + 1;
        this.title = title;
        this.quantity = quantity;
        this.frequency = frequency;
        store.store.add(this);
    }

}

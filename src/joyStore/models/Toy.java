package joyStore.models;

public class Toy {
    private String name;
    private int totalQuantity;
    private final int id;
    private double dropChance;

    private static int counter = 1;

    public Toy(String name, int totalQuantity, double dropChance) {
        this.name = name;
        this.totalQuantity = totalQuantity;
        this.dropChance = dropChance;
        this.id = counter++;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, name: %s, totalQuantity: %s, dropChance: %s\n", this.id, this.name,
                this.totalQuantity, this.dropChance);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        Toy toy = (Toy) obj;
        return toy.name == this.name && toy.id == this.id;
    }

    public String getName() {
        return name;
    }

    public double getDropChance() {
        return dropChance;
    }

    public void setDropChance(double dropChance) {
        this.dropChance = dropChance;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }
}

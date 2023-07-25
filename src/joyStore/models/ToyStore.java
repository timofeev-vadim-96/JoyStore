package joyStore.models;

import java.util.HashSet;
import java.util.Set;

public class ToyStore {
    private String name;
    private final Set<Toy> toys = new HashSet<>();

    public ToyStore(String name) {
        this.name = name;
    }

    public ToyStore addToy (Toy inputToy){
        toys.add(inputToy);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getInfo(){
        System.out.printf("In the store totally %s toys\n", toys.size());
        for (Toy toy:toys) {
            System.out.println(toy);
        }
    }

    public Set<Toy> getToys(){
        return toys;
    }

    public void removeToy(Toy toy){
        toys.remove(toy);
    }
}

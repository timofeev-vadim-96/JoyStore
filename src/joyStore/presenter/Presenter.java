package joyStore.presenter;

import joyStore.models.PrizeToys;
import joyStore.models.Toy;
import joyStore.models.ToyStore;
import joyStore.util.Probability;

import java.util.Set;

public class Presenter {
    private ToyStore toyStore;
    private PrizeToys prizeToys;

    public Presenter() {
        this.toyStore = new ToyStore("Default name");
        this.prizeToys = new PrizeToys();
    }

    public String tryToWinToy(){
        Set<Toy> toys = toyStore.getToys();
        if (toys.size() < 1) return "empty";
        for (Toy toy: toys) {
            if (toy.getTotalQuantity() < 1) continue;
            Probability probability = new Probability(toy.getDropChance());
            if (probability.isObjectFallen()){
                toy.setTotalQuantity(toy.getTotalQuantity()-1);
                prizeToys.addPrizeToy(toy.getName());
                return toy.getName();
            };
        }
        return "False";
    }

    public void getInfo(){
        toyStore.getInfo();
    }

    public String getStoreName(){
        return toyStore.getName();
    }

    public void addToy(Toy toy){
        toyStore.addToy(toy);
    }

    public void getPrizeToys(){
        prizeToys.getAllPrizeToys();
    }
}

package joyStore.presenter;

import joyStore.logger.Loggerable;
import joyStore.models.PrizeToys;
import joyStore.models.Toy;
import joyStore.models.ToyStore;
import joyStore.util.Probability;

import java.io.IOException;
import java.util.Set;

public class Presenter {
    private ToyStore toyStore;
    private PrizeToys prizeToys;
    private Loggerable logger;

    public Presenter(Loggerable logger) {
        this.toyStore = new ToyStore("Default name");
        this.prizeToys = new PrizeToys();
        this.logger = logger;
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

    public void setName (String storeName){
        toyStore.setName(storeName);
    }
    public void log (String text) throws IOException {
        logger.log(text);
    }

    public void setDropChance(String name, double dropChance){
        for (Toy toy: toyStore.getToys()) {
            if (toy.getName().equals(name)){
                toy.setDropChance(dropChance);
            }
        }
    }

    public boolean searchToy(String name){
        for (Toy toy: toyStore.getToys()) {
            if (toy.getName().equals(name)) return true;
        }
        return false;
    }
}

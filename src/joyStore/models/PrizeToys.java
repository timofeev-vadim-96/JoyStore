package joyStore.models;

import java.util.ArrayList;
import java.util.List;

public class PrizeToys {
    private final List<String> prizeToys = new ArrayList<>();

    public void addPrizeToy(String toy){
        prizeToys.add(toy);
    }

    public void getAllPrizeToys(){
        if (prizeToys.size() > 0){
            System.out.println("Your prize include:");
            for (int i = 0; i < prizeToys.size(); i++) {
                System.out.println(prizeToys.get(i));
                prizeToys.remove(i);
                i--;
            }
        }
        else System.out.println("You haven't won any toys yet.");
    }
}

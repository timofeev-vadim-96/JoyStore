package joyStore.view;

import joyStore.models.Toy;
import joyStore.presenter.Presenter;
import joyStore.util.Command;

import java.util.Scanner;

public class View {
    Presenter presenter;
    Scanner in;

    public View() {
        this.presenter = new Presenter();
        this.in = new Scanner(System.in);
    }

    public void run(){
        Command com;
        instruction();
        while(true){
            String command = prompt("Enter the command: (INFO/ADD/TRY/PRIZE/HELP/EXIT)\n");
            commandValidation(command);
            com = Command.valueOf(command);
            if (com == Command.EXIT) return;
            switch (com) {
                case TRY:
                    tryToWinToy();
                    break;
                case INFO:
                    presenter.getInfo();
                    break;
                case ADD:
                    Toy newToy = createNewToy();
                    presenter.addToy(newToy);
                    System.out.printf("%s was added successfully\n", newToy.getName());
                    break;
                case PRIZE:
                    presenter.getPrizeToys();
                    break;
                case HELP:
                    instruction();
                    break;
            }
            }
        }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine().toUpperCase();
    }


    private boolean commandValidation(String action){
        try{
            Enum.valueOf(Command.class, action);
            return true;
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Unexpected command! ");
        }

    }
    public void tryToWinToy(){
        String result = presenter.tryToWinToy();
        if (result.equals("False")) {
            System.out.println("Unfortunately, you lost. You can try again\n");
        }
        else if (result.equals("empty")){
            System.out.println("The store is empty\n");
        }
        else System.out.printf("congratulations, you won a %s\n", result);
    }

    public void instruction() {
        System.out.printf(
                        "****TOY STORE %s****\n" +
                        "INSTRUCTION:\n" +
                                "INFO - show all toys in the store\n" +
                                "ADD - add a toy to the store\n" +
                                "TRY - try to win a toy\n" +
                                "PRIZE - get all the won toys\n" +
                                "HELP - show the instruction\n" +
                                "EXIT - exit the app\n", presenter.getStoreName());
    }

    public Toy createNewToy(){
        String name = prompt("Enter the name: \n");
        int quantity = Math.abs(Integer.parseInt(prompt("Enter the quantity: \n")));
        double dropChance = Math.abs(Double.parseDouble(prompt("Enter the drop chance: \n")));
        return new Toy(name, quantity, dropChance);
    }
}

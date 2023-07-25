package joyStore.util;

import java.util.Random;

public class Probability {
    private double probability;

    public Probability(double probability) {
        this.probability = probability;
    }

    public boolean isObjectFallen() {
        Random random = new Random();
        double randomProbability = random.nextDouble() * 100;
        return randomProbability <= probability;
    }
}

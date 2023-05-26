package com.example.finalapp.Domain;
import java.util.Random;

public class RandomName {
    private Random random;
    private String[] subjects = {"Mich", "Shane", "Sheer", "Jeno", "Kristean","Raiza","Franco",
            "Emmanuel","Rhoilan","Felicity","Daniel","Smog","Paz","Chris","Jersey","Beniga","Raul"};

    public RandomName() {
        random = new Random();
    }

    public String generateRandomSentence() {
        String name = getRandomElement(subjects);

        return name;
    }

    private String getRandomElement(String[] array) {
        int index = random.nextInt(array.length);
        return array[index];
    }
}

package Model.Dice;

import java.util.Random;

public class Die {
    private int maxValue;

    public Die() {
        this.maxValue = 6; //Default dice size.
    }

    public Die(int sides) {
        this.maxValue = sides; //Flexible dice size.
    }

    public int rollDie() {
        Random rand = new Random();
        return rand.nextInt(maxValue);
    }
}

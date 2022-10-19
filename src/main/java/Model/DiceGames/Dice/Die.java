package Model.DiceGames.Dice;

import java.util.Random;

public class Die {
    private final int maxValue;
    private int faceValue;
    private String currentImagePath;

    public Die() {
        this.maxValue = 6; //Default dice nr of sides.
        this.faceValue = 1; //Default face value.
        updateCurrentImagePath();
    }

    public Die(int sides) {
        this.maxValue = sides; //Flexible dice nr of sides.
        updateCurrentImagePath();
    }

    public void rollDie() {
        this.faceValue = new Random().nextInt(maxValue) + 1; //Sets the current value to a random "side" of the dice.
    }

    public void setFaceValue(int value) {
        this.faceValue = value;
    }

    public int getVal() {
        return faceValue;
    }

    public String getCurrentImagePath() {
        return currentImagePath;
    }

    public void updateCurrentImagePath(){
        currentImagePath = "src/main/resources/resources_img/dice/die" + faceValue + ".png";
    }
}

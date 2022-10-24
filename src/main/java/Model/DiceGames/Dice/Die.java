package Model.DiceGames.Dice;

import java.util.Random;

public class Die {
    private final int maxValue;
    private int faceValue;
    private String currentImagePath;

    /**
     * Constructor for die.
     */
    public Die() {
        this.maxValue = 6; //Default dice nr of sides.
        this.faceValue = 1; //Default face value.
        updateCurrentImagePath();
    }

    /**
     * Constructor for die given nr of sides.
     * @param sides
     */
    public Die(int sides) {
        this.maxValue = sides; //Flexible dice nr of sides.
        updateCurrentImagePath();
    }

    /**
     * Sets the face value of a die to a random number given its nr of sides (max value).
     */
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

    /**
     * Updates the image path the dice has. Path contains an image with the given face value.
     */
    public void updateCurrentImagePath(){
        currentImagePath = "src/main/resources/resources_img/dice/die" + faceValue + ".png";
    }
}

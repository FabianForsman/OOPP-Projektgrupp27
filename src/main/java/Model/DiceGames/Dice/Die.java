package Model.DiceGames.Dice;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Die {

    private final int maxValue;
    private int faceValue;

    public Die() {
        this.maxValue = 6; //Default dice nr of sides.
        this.faceValue = 1; //Default face value.
    }

    public Die(int sides) {
        this.maxValue = sides; //Flexible dice nr of sides.
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
}

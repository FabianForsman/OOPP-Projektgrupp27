package Model.DiceGames.Dice;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    List<Die> dice = new ArrayList<>();

    public Dice(int nrOfDie) { //For 6-sided dice
        for(int i = 0; i < nrOfDie; i++) {
            dice.add(new Die());
        }
    }

    public Dice(int nrOfDie, int dieSides){ //For x-sided dice
        for(int i = 0; i < nrOfDie; i++) {
            dice.add(new Die(dieSides));
        }
    }

    public void addDie(int dieSides){
        dice.add(new Die(dieSides));
    }

    public void removeDie(Die die){
        if(dice.size() > 1)
            dice.remove(die);
        else
            System.out.println("Cannot remove all die!");
    }

    public void rollAllDice() {
        for(Die die : dice) {
            die.rollDie();
        }
    }

    public void rollDie(Die die) { //Roll a single die
        die.rollDie();
    }

    public Die getDie(int i){
        return dice.get(i);
    }

    public List<Integer> getDiceValues() {
        List<Integer> returnList = new ArrayList<>();
        for(Die die: dice){
            returnList.add(die.getFaceValue());
        }
        return returnList;
    }

    public int getDieValue(Die die) {
        return die.getFaceValue();
    }
}

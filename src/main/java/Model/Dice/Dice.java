package Model.Dice;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    List<Die> dice = new ArrayList<>();
    public Dice(int nrOfDie) {
        for(int i = 0; i < nrOfDie; i++) {
            dice.add(new Die());
        }
    }

    public Dice(int nrOfDie, int dieSides){
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

    public List<Integer> rollAllDice() {
        List<Integer> rolledDice = new ArrayList<>();
        for(Die die : dice) {
            rolledDice.add(die.rollDie());
        }
        return rolledDice;
    }

    public int rollDie(Die die) {
        return die.rollDie();
    }
}

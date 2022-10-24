package Model.DiceGames.Dice;


import java.util.ArrayList;
import java.util.List;

public class Dice {
    private List<Die> dice = new ArrayList<>();

    /**
     * Constructor of dice.
     * @param nrOfDie
     */
    public Dice(int nrOfDie) { //For 6-sided dice
        for(int i = 0; i < nrOfDie; i++) {
            dice.add(new Die());
        }
    }

    /**
     * Constructor of dice with die that has specific nr of sides.
     * @param nrOfDie
     * @param dieSides
     */
    public Dice(int nrOfDie, int dieSides){ //For x-sided dice
        for(int i = 0; i < nrOfDie; i++) {
            dice.add(new Die(dieSides));
        }
    }

    /**
     * Adds a new 6-sided die to all dice.
     */
    public void addDie() { dice.add(new Die()); }


    /**
     * Adds a new n-sided die to all dice.
     * @param dieSides
     */
    public void addDie(int dieSides){
        dice.add(new Die(dieSides));
    }


    /**
     * Removes a die from all dice.
     * @param die
     */
    public void removeDie(Die die){
        if(dice.size() > 1) {
            dice.remove(die);
        }
    }

    /**
     * Rolls all dice.
     */
    public void rollAllDice() {
        for(Die die : dice) {
            die.rollDie();
        }
    }

    /**
     * Rolls a specific die.
     * @param die
     */
    public void rollDie(Die die) { //Roll a single die
        die.rollDie();
    }

    public Die getDie(int i){
        return dice.get(i);
    }

    public ArrayList<Integer> getDiceValues() {
        ArrayList<Integer> returnList = new ArrayList<>();
        for(Die die : dice){
            returnList.add(die.getVal());
        }
        return returnList;
    }

    /**
     * Gets die value given the die.
     * @param die
     * @return
     */
    public int getDieValue(Die die) {
        return die.getVal();
    }

    /**
     * Gets die value given an index in all dice.
     * @param i
     * @return
     */
    public int getDieValue(int i) {
        return dice.get(i).getVal();
    }

    /**
     * Sets the value for all dice.
     * @param values
     */
    public void setDiceValue(ArrayList<Integer> values) {
        int i = 0;
        for(Die die : dice) {
            die.setFaceValue(values.get(i));
            i++;
        }
    }
}

package Model.DiceGames.Dice.Treman;

import Model.DiceGames.Dice.Dice;
import Model.DiceGames.Dice.Die;

public abstract class TremanRules {
    String snakeEyes = "Two ones, Snake Eyes! Take two or give them away.";
    String equals = "Two of the same! Give them away.";
    String noseTouch = "Touch your nose! Last one takes one.";
    String treman = "Treman! Treman, take one. ";
    String newTreman = "New treman! Give the hat to someone else.";
    String noSix = "Six is good, but not here!.";
    String endTurn = " Pass the dice along.";
    String sevenAhead = "Seven ahead. Person in front of you takes one.";
    String notSoGreat = "Eight not so great.";
    String nineBehind = "Nine behind. Person behind you takes one.";
    String cheers = "Cheers! Everyone takes one.";
    String hell = "Hell!";

    public String getRule(Dice dice) {
        Die die1 = dice.getDie(0);
        Die die2 = dice.getDie(1);
        String returnString = "";

        if ((die1.getFaceValue() == 3 || die2.getFaceValue() == 3) && die1.getFaceValue() != die2.getFaceValue()){
            returnString += treman;
        } else {
            return newTreman;
        }

        if (die1.getFaceValue() == die2.getFaceValue()) {
            if (die1.getFaceValue() == 1) {
                return returnString + snakeEyes;
            } else {
                return returnString + equals;
            }
        }

        if (die1.getFaceValue() == 1 && die2.getFaceValue() == 4 || die1.getFaceValue() == 4 && die2.getFaceValue() == 1) {
            return returnString + noseTouch;
        }

        if (returnString.equals("") && (die1.getFaceValue() + die2.getFaceValue() == 6)) {
            return returnString + noSix + endTurn;
        }

        switch(die1.getFaceValue() + die2.getFaceValue()) {
            case 7: return returnString + sevenAhead;
            case 8: return returnString + notSoGreat + endTurn;
            case 9: return returnString + nineBehind;
            case 10: return cheers;
            case 11: return hell + endTurn;
        }

        if(!returnString.equals("")) {
            return returnString;
        } else{
            return "No rule found.";
        }
    }

}

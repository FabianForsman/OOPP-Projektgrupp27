package Model.DiceGames.Treman;
import Model.DiceGames.Dice.Dice;
import Model.DiceGames.Treman.Rules.Treman;
import Model.Player.IPlayer;

import java.util.ArrayList;

public class TremanGamePanel {
    TremanRules rules;
    Dice dice;
    ArrayList<IPlayer> players =  new ArrayList<>();

    public TremanGamePanel() {
        //Players and such. Gets from previous pages.
        dice = new Dice(2);
        rules = new TremanRules();
    }

    public String getRule() {
        int a = dice.getDiceValues().get(0);
        int b = dice.getDiceValues().get(1);
        String treman = Treman.checkIfTreman(a, b);
        String returnString  = rules.r1.getRule(a, b);
        String keep = "Keep - ";
        String pass = "Pass - ";

        if (returnString.contains("Challenge completed!")) {
            System.out.println("Challenge WIP.");
        }

        if (returnString.contains("Dice passing out completed.")) {
            System.out.println("Two of the same WIP.");
        }

        if (returnString.contains(keep)) {
            if (returnString.equals("Keep - New treman! Give the hat to someone else.")){
                return returnString;
            }
            return returnString + treman;
        } else if (returnString.contains(pass)) {
            if (treman.equals("")) {
                return returnString;
            }
            return treman;
        } else if (returnString.equals("No Rule Found.\n")) {
            if (!treman.equals("")) {
                return treman;
            }
            return returnString;
        }
        return returnString; // Failsafe, will return the rule the CoC passed that isn't specified.
    }

    public Dice getDice() {
        return dice;
    }

}

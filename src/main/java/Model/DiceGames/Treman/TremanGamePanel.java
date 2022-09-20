package Model.DiceGames.Treman;
import Model.DiceGames.Dice.Dice;

public class TremanGamePanel {
    TremanRules rules;
    Dice dice;

    public TremanGamePanel() {
        //Players and such. Gets from previous pages.
        dice = new Dice(2);
        rules = new TremanRules();
    }

    public String getRule() {
        return rules.getRule(dice);
    }

    public Dice getDice() {
        return dice;
    }
}

package Model.DiceGames.Dice.Treman;

import Model.DiceGames.Dice.Dice;

public class TremanGamePanel {
    TremanRules rules;
    Dice dice;
    public TremanGamePanel() {
        //Players and such. Gets from previous pages.
        dice = new Dice(2);

    }
}

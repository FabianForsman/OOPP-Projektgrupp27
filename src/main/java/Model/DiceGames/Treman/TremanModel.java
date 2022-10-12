package Model.DiceGames.Treman;
import Model.DiceGames.Dice.Dice;
import Model.DiceGames.Treman.Actions.IAction;
import Model.DiceGames.Treman.Actions.NoAction;
import Model.DiceGames.Treman.Actions.PassAction;
import Model.DiceGames.Treman.Rules.Treman;
import Model.Game;
import Model.Player.IPlayer;
import Model.Player.Players;

import java.util.ArrayList;


public class TremanModel extends Game{
    private final TremanRules rules;
    private static Dice dice;
    private static IPlayer treman;

    public TremanModel() {
        // Players and such. Gets from previous pages.
        super();
        dice = new Dice(2);
        rules = new TremanRules();
        treman = Players.getInstance().getRandomPlayer();
        Players.getInstance().setRandomCurrentPlayer();
    }

    public static void setNewTreman(IPlayer player) {
        treman = player;
    }

    @Override
    public void nextTurn() {

    }

    @Override
    public void restartGame() {

    }

    @Override
    public void quitGame() {

    }

    @Override
    public void startGame() {

    }

    @Override
    public void startRound() {

    }

    public String getRule() {
        return getAction().getRuleString();
    }

    private IAction getAction() {
        int a = dice.getDieValue(0);
        int b = dice.getDieValue(1);

        IAction tremanAction = Treman.checkIfTreman(a, b);
        String tremanString = tremanAction.getRuleString();

        IAction rule  = rules.r1.getRule(a, b); // Should return an action and string, an object with both.
        String combinedString = tremanAction.getRuleString() + " " + rule.getRuleString();

        boolean treman = !tremanString.equals("");

        if(rule instanceof PassAction) {
            if(treman) {
                return tremanAction;
            }
            return rule;
        } else if(rule instanceof NoAction) {
            if(treman) {
                if(rule.getRuleString().equals("No rule found.")) {
                    return tremanAction;
                }
                return new NoAction(tremanString + " " + rule.getRuleString());
            }
        }
        return rule;
    }

    public Dice getDice() {
        return dice;
    }

    public ArrayList<Integer> getDiceValues() {
        return dice.getDiceValues();
    }

}

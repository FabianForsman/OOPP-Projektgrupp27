package Model.DiceGames.Treman;
import Model.DiceGames.Dice.Dice;
import Model.DiceGames.Dice.Die;
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

    /**
     * Constructor for TremanModel.
     */
    public TremanModel() {
        super();
        dice = new Dice(2);
        rules = new TremanRules();
    }

    public static void setNewTreman(IPlayer player) {
        treman = player;
    }

    public static void setRandomCurrentPlayer() {
        Players.getInstance().setRandomCurrentPlayer();
    }

    public static void setRandomTreman() {
        treman = Players.getInstance().getRandomPlayer();
    }

    public static IPlayer getTreman() {
        return treman;
    }

    public String getTremanName() {
        return treman.getName();
    }

    public String getRule() {
        return getAction().getRuleString();
    }

    /**
     * Gets the dice values and passes them through the chain of responsibility. Depending on the result of
     * checkIfTreman, manipulate the return-action or create a new one, as the checkIfTreman-method has
     * specific rule-adaptations that the other treman-rules have to take into account.
     * @return
     */
    public IAction getAction() {
        int a = dice.getDieValue(0);
        int b = dice.getDieValue(1);

        IAction tremanAction = Treman.checkIfTreman(a, b);
        String tremanString = tremanAction.getRuleString();

        IAction rule  = rules.r1.getRule(a, b);
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

    public Die getDie(int i) {
        return dice.getDie(i);
    }

    public ArrayList<Integer> getDiceValues() {
        return dice.getDiceValues();
    }

}

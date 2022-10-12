package Model.DiceGames.Treman.Rules;

import Model.DiceGames.Treman.Actions.IAction;
import Model.DiceGames.Treman.Actions.NoAction;
import Model.DiceGames.Treman.IRulesChain;

public class Cheers implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public IAction getRule(int a, int b) {
        if (a + b == 10) {
            return new NoAction("Cheers! Everyone takes one.");
        }
        return this.chain.getRule(a, b);
    }
}
package Model.DiceGames.Treman.Rules;

import Model.DiceGames.Treman.Actions.IAction;
import Model.DiceGames.Treman.Actions.NoAction;
import Model.DiceGames.Treman.IRulesChain;

public class NoseTouch implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public IAction getRule(int a, int b) {
        if (a == 1 && b == 4 || a == 4 && b == 1) {
            return new NoAction("Touch your nose! Last one to do it takes one.");
        }
        return this.chain.getRule(a, b);
    }
}

package Model.DiceGames.Treman.Rules;

import Model.DiceGames.Treman.Actions.EqualsAction;
import Model.DiceGames.Treman.Actions.IAction;
import Model.DiceGames.Treman.IRulesChain;

public class Equals implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public IAction getRule(int a, int b) {
        if (a == b) {
            return new EqualsAction();
        }

        return this.chain.getRule(a, b);
    }
}

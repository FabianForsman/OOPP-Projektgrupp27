package Model.DiceGames.Treman.Rules;

import Model.DiceGames.Treman.Actions.IAction;
import Model.DiceGames.Treman.Actions.NoAction;
import Model.DiceGames.Treman.Actions.PassAction;
import Model.DiceGames.Treman.IRulesChain;

public class NotSix implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public IAction getRule(int a, int b) {
        if (a + b == 6) {
            return new PassAction("Six is good, but not here.");
        }
        return this.chain.getRule(a, b);
    }
}

package Model.DiceGames.Treman.Rules;

import Model.DiceGames.Treman.Actions.IAction;
import Model.DiceGames.Treman.Actions.PassAction;
import Model.DiceGames.Treman.IRulesChain;

public class Hell implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public IAction getRule(int a, int b) {
        if (a + b == 11) {
            return new PassAction("Pass - Hell! Pass the dice along.");
        }
        return this.chain.getRule(a, b);
    }
}

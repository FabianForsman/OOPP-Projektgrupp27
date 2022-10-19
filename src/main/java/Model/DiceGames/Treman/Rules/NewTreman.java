package Model.DiceGames.Treman.Rules;

import Model.DiceGames.Treman.Actions.IAction;
import Model.DiceGames.Treman.Actions.NewTremanAction;
import Model.DiceGames.Treman.IRulesChain;

public class NewTreman implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public IAction getRule(int a, int b) {
        if (a == 3 && b == 3) {
            return new NewTremanAction();
        }
        return this.chain.getRule(a, b);
    }
}

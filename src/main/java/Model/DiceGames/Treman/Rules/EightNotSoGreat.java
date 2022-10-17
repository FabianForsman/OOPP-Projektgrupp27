package Model.DiceGames.Treman.Rules;

import Model.DiceGames.Treman.Actions.IAction;
import Model.DiceGames.Treman.Actions.PassAction;
import Model.DiceGames.Treman.IRulesChain;

public class EightNotSoGreat implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public IAction getRule(int a, int b) {
        if (a + b == 8) {
            return new PassAction("Eight not so great! Passing the dice along.");
        }

        return  this.chain.getRule(a, b);
    }
}
package Model.DiceGames.Treman.Rules;

import Model.DiceGames.Treman.Actions.IAction;
import Model.DiceGames.Treman.IRulesChain;

public class NineBehind implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public IAction getRule(int a, int b) {
        if (a + b == 9) {
            return "Keep - Nine behind. Person behind you takes one.\n";
        }
        return this.chain.getRule(a, b);
    }
}
package Model.DiceGames.Treman.Rules;

import Model.IRulesChain;

public class NotSix implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String getRule(int a, int b) {
        if (a + b == 6) {
            return "Pass - Six is good, but not here.\n";
        }
        return this.chain.getRule(a, b);
    }
}

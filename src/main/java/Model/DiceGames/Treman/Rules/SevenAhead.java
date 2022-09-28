package Model.DiceGames.Treman.Rules;

import Model.IRulesChain;

public class SevenAhead implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String getRule(int a, int b) {
        if (a + b == 7) {
            return "Keep - Seven ahead! Person in front of you takes one.\n";
        }
        return this.chain.getRule(a, b);
    }
}
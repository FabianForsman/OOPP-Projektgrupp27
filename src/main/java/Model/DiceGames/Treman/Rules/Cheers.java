package Model.DiceGames.Treman.Rules;

import Model.IRulesChain;

public class Cheers implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String getRule(int a, int b) {
        if (a + b == 10) {
            return "Keep - Cheers! Everyone takes one.\n";
        }
        return this.chain.getRule(a, b);
    }
}
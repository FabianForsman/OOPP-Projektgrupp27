package Model.DiceGames.Treman.Rules;

import Model.IRulesChain;

public class EightNotSoGreat implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String getRule(int a, int b) {
        if (a + b == 8) {
            return "Pass - Eight not so great.\n";
        }

        return  this.chain.getRule(a, b);
    }
}
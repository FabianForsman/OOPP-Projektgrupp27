package Model.DiceGames.Treman.Rules;

import Model.IRulesChain;

public class Challenge implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String getRule(int a, int b) {
        if (a == 1 && b == 2 || a == 2 && b == 1) {
            return "Challenge completed!\n";
        }
        return this.chain.getRule(a, b);
    }
}

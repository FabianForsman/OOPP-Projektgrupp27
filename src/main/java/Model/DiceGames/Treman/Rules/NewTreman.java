package Model.DiceGames.Treman.Rules;

import Model.IRulesChain;

public class NewTreman implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String getRule(int a, int b) {
        if (a == 3 && b == 3) {
            return "Keep - New treman! Give the hat to someone else.\n";
        }
        return this.chain.getRule(a, b);
    }
}

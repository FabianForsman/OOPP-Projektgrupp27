package Model.DiceGames.Treman.Rules;

import Model.IRulesChain;

public class Hell implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String getRule(int a, int b) {
        if (a + b == 11) {
            return "Pass - Hell! Pass the dice along.\n";
        }
        return this.chain.getRule(a, b);
    }
}

package Model.DiceGames.Treman.Rules;

import Model.IRulesChain;

public class NoseTouch implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String getRule(int a, int b) {
        if (a == 1 && b == 4 || a == 4 && b == 1) {
            return "Keep - Touch your nose! Last one to do it takes one.\n";
        }
        return this.chain.getRule(a, b);
    }
}

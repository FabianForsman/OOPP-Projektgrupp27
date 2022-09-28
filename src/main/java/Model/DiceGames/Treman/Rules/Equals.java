package Model.DiceGames.Treman.Rules;

import Model.IRulesChain;

public class Equals implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String getRule(int a, int b) {
        if (a == b) {
            if (a == 1) {
                return "Keep - Two ones, Snake Eyes! Take two or give them away.\n";
            }
            return "Dice passing out completed.\n";
        }

        return this.chain.getRule(a, b);
    }
}

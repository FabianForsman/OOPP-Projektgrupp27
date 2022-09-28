package Model.DiceGames.Treman.Rules;

import Model.IRulesChain;

public class NoRuleFound implements IRulesChain{
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String getRule(int a, int b) {
        return "No Rule Found.\n";
    }
}

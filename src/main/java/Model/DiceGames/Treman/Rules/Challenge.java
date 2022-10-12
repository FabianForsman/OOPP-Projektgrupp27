package Model.DiceGames.Treman.Rules;

import Model.DiceGames.Treman.Actions.ChallengeAction;
import Model.DiceGames.Treman.Actions.IAction;
import Model.DiceGames.Treman.IRulesChain;

public class Challenge implements IRulesChain {
    private IRulesChain chain;

    @Override
    public void setNextChain(IRulesChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public IAction getRule(int a, int b) {
        if (a == 1 && b == 2 || a == 2 && b == 1) {
            return new ChallengeAction();
        }
        return this.chain.getRule(a, b);
    }
}

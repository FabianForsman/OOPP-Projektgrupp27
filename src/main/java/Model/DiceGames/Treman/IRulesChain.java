package Model.DiceGames.Treman;

import Model.DiceGames.Treman.Actions.IAction;

public interface IRulesChain {
    void setNextChain(IRulesChain nextChain);
    IAction getRule(int a, int b);
}

package Model.DiceGames.Treman;

import Model.DiceGames.Treman.Rules.*;
import Model.IRulesChain;

class TremanRules {
    public IRulesChain r1;

    public TremanRules() {
        // Initialize the chain
        this.r1 = new NewTreman();
        IRulesChain r2 = new Equals();
        IRulesChain r3 = new NoseTouch();
        IRulesChain r4 = new NotSix();
        IRulesChain r5 = new SevenAhead();
        IRulesChain r6 = new EightNotSoGreat();
        IRulesChain r7 = new NineBehind();
        IRulesChain r8 = new Cheers();
        IRulesChain r9 = new Hell();
        IRulesChain r10 = new Challenge();
        IRulesChain r11 = new NoRuleFound();

        // Set the chain of responsibility
        r1.setNextChain(r2);
        r2.setNextChain(r3);
        r3.setNextChain(r4);
        r4.setNextChain(r5);
        r5.setNextChain(r6);
        r6.setNextChain(r7);
        r7.setNextChain(r8);
        r8.setNextChain(r9);
        r9.setNextChain(r10);
        r10.setNextChain(r11);
    }
}

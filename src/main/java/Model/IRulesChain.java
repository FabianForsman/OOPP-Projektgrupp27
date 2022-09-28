package Model;

public interface IRulesChain {
    void setNextChain(IRulesChain nextChain);
     String getRule(int a, int b);
}

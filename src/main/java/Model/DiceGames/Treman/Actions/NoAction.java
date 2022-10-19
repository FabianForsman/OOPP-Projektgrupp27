package Model.DiceGames.Treman.Actions;

public class NoAction implements IAction {

    private final String returnString;

    public NoAction(String string) {
        this.returnString = string;
    }

    @Override
    public String getRuleString() {
        return returnString;
    }
}

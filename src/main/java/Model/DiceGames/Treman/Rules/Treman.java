package Model.DiceGames.Treman.Rules;

import Model.DiceGames.Treman.Actions.IAction;
import Model.DiceGames.Treman.Actions.NoAction;

public abstract class Treman {

    public static IAction checkIfTreman(int a, int b) {
        if ((a == 3 || b == 3) && a != b) {
            return new NoAction( "Treman! Treman takes one.");
        }
        return new NoAction("");
    }
}

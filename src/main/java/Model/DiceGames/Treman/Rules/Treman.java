package Model.DiceGames.Treman.Rules;

public abstract class Treman {

    public static String checkIfTreman(int a, int b) {
        if (a == 3 || b == 3) {
            return "Treman! Treman takes one.\n";
        }
        return "";
    }
}

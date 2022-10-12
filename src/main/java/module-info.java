module com.example.hydrohomies {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.hydrohomies to javafx.fxml;
    exports com.example.hydrohomies;
    exports Model.Player;
    opens Model.Player to javafx.fxml;
    exports Model.CardGames.HigherLower;
    exports Model.DiceGames.Opus;
    exports Model.DiceGames.Treman;
    exports Model.DiceGames.Dice;
    opens Model.DiceGames.Opus to javafx.fxml;
    exports Model;
    exports Controllers.HigherLower;
    exports Model.DiceGames.Treman.Rules;
}
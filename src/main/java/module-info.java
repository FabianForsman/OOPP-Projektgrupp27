module com.example.hydrohomies {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
   // requires org.jetbrains.annotations;


    opens com.example.hydrohomies to javafx.fxml;
    exports com.example.hydrohomies;
    exports Model.Player;
    opens Model.Player to javafx.fxml;
    exports Model.CardGames.HigherLower;
    exports Model.DiceGames.Opus;
    exports Model.DiceGames.Treman;
    exports Model.DiceGames.Dice;
    exports Model.CardGames.Cards;
    exports Model.CardGames.FTheDealer;
    opens Model.DiceGames.Opus to javafx.fxml;
    exports Model;
    exports Model.DiceGames.Treman.Rules;
    exports View;
    opens View to javafx.fxml;
    exports Controllers;
    opens Controllers to javafx.fxml;
}
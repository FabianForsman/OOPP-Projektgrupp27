package Model.DiceGames.Opus;

import Model.Audio.SongPlayer;
import Model.DiceGames.Dice.Dice;
import Model.DiceGames.Dice.Die;
import Model.Player.IPlayer;
import Model.Player.Players;
import View.OpusView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;

public class OpusController {

    OpusModel model;
    OpusView view;
    Die die;
    SongPlayer songPlayer;
    int nrOfRolls = 0;

    @FXML
    private Button rollDiceButton;

    @FXML
    private ComboBox<IPlayer> playerList;

    @FXML
    private AnchorPane playerListPane;



    public void startGame(ActionEvent actionEvent) {
        model.startDropTimer();
        songPlayer.playSong("C:\\Songs");
        Players.getInstance().setRandomCurrentPlayer();
    }

    public void rollDice(ActionEvent actionEvent) {
        die.rollDie();
        nrOfRolls++;
        if (model.checkIfOneSixFirstTry(die.getVal(), nrOfRolls)) {
            playerListPane.toFront();



        }
        model.checkIfOneOrSix();

    }

}

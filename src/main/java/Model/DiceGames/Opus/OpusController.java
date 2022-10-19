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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;

public class OpusController {

    OpusModel model;
    OpusView view;
    Die die;
    SongPlayer songPlayer;
    int nrOfRolls = 0;
    Timer timer = new Timer();

    @FXML
    private Button rollDiceButton;

    @FXML
    private ComboBox<IPlayer> playerList;

    @FXML
    private AnchorPane playerListPane;

    @FXML
    private AnchorPane drinkMessagePane;

    @FXML
    private Label drinkMessageLabel;

    @FXML
    private Label currentPlayerLabel;


    @FXML
    public void startGame(ActionEvent actionEvent) {
        songPlayer.playSong("C:\\Songs");
        Players.getInstance().setRandomCurrentPlayer();
    }

    @FXML
    public void rollDice(ActionEvent actionEvent) {
        die.rollDie();
        nrOfRolls++;
        if (model.checkIfOneSixFirstTry(die.getVal(), nrOfRolls)) {
            playerListPane.toFront();

        }
        else
        model.checkIfOneOrSix();
    }

    public void updateDrinkDisplayText() {
        drinkMessageLabel.setText(model.getCurrentPlayerDrinkText());
    }

    @FXML
    public void displayDrinkImage(){
        drinkMessagePane.toFront();
    }

    @FXML
    public void choosePlayer(IPlayer player){
        //currentPlayerLabel.setText(toString(player));



    }

    public void startDropTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                displayDrinkImage();}
        };
        long delay = 225;
        timer.schedule(task, delay);
    }

    @FXML
    public void roll(){
        rollDiceButton.setDisable(true);
    }



}

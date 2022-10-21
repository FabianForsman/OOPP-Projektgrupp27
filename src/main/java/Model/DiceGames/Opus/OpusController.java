package Model.DiceGames.Opus;

import Model.Audio.SongPlayer;
import Model.DiceGames.Dice.Dice;
import Model.DiceGames.Dice.Die;
import Model.DiceGames.Treman.TremanModel;
import Model.Player.IPlayer;
import Model.Player.Players;
import View.OpusView;
import com.example.hydrohomies.UIController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class OpusController implements Initializable {

    private UIController parentController;
    OpusModel model;
    OpusView view;
    Die die;
    SongPlayer songPlayer;
    int nrOfRolls = 0;
    Timer timer = new Timer();

    @FXML private Button rollDiceButton;
    @FXML private Button opusGameStartButton;
    @FXML private ComboBox<IPlayer> playerList;
    @FXML private AnchorPane playerListPane;
    @FXML private AnchorPane drinkMessagePane;
    @FXML private Label drinkMessageLabel;
    @FXML private Label currentPlayerLabel;


    public OpusController(UIController parentController) {
        this.parentController = parentController;
        model = new OpusModel();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    public void startGame(ActionEvent actionEvent) {
        songPlayer.playSong("C:\\Songs");
        Players.getInstance().setRandomCurrentPlayer();
    }

    @FXML
    public void rollDice(ActionEvent actionEvent, IPlayer player) {

        die.rollDie();
        nrOfRolls++;
        if (model.checkIfOneSixFirstTry(die.getVal(), nrOfRolls)) {
            playerListPane.toFront();
            updateCurrentPlayerTexts();
        }
        else
        model.checkIfOneOrSix();
        updateCurrentPlayerTexts();

    }



    public void setCurrentPlayerLabel() {
        currentPlayerLabel.setText(Players.getInstance().getCurrentPlayerName());

    }

    public void updateDrinkDisplayText() {
        drinkMessageLabel.setText(model.getCurrentPlayerDrinkText());
    }

    public void updateCurrentPlayerTexts(){
        setCurrentPlayerLabel();
        updateDrinkDisplayText();
    }

    public void choosePlayer(IPlayer player){
        Players.getInstance().setCurrentPlayer(player);

    }

    @FXML
    public void displayDrinkImage(){
        drinkMessagePane.toFront();
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



}

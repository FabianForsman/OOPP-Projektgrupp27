package Model.DiceGames.Opus;

import Controllers.SceneHandler;
import Model.Audio.SongPlayer;
import Model.DiceGames.Dice.Dice;
import Model.DiceGames.Dice.Die;
import Model.DiceGames.Treman.TremanModel;
import Model.Player.IPlayer;
import Model.Player.Players;
import View.OpusView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class OpusController implements Initializable {

    OpusModel model;
    OpusView view;
    Die die;
    SongPlayer songPlayer;
    int nrOfRolls = 0;
    Timer timer = new Timer();
    Random random = new Random();
    private SceneHandler handler;

    private Button rollDiceButton;
    private Button opusGameStartButton;
    private ComboBox<IPlayer> playerList;
    private AnchorPane playerListPane;
    private AnchorPane drinkMessagePane;
    private Label drinkMessageLabel;
    private Label currentPlayerLabel;

    private ListView<String> selectedPlayersListView;



    public OpusController(SceneHandler handler) {
        model = new OpusModel();
        this.handler = handler;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    public void startGame(ActionEvent actionEvent) {
        songPlayer.playSong("C:\\Songs");
        Players.getInstance().setRandomCurrentPlayer();
    }


    public void rollDice() {

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

    public void roll(ImageView image) {
        rollAnimation(image);
    }

    public void rollAnimation(ImageView image) {
        try {
            for (int i = 0; i < 10; i++) {
                FileInputStream stream = new FileInputStream("src/main/resources/resources_img/dice/die" + (random.nextInt(6) + 1) + ".png");
                Image image1 = new Image(stream);
                image.setImage(image1);
                Thread.sleep(20);
            }
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setCurrentPlayerLabel(Label currentPlayerLabel) {
        currentPlayerLabel.setText(Players.getInstance().getCurrentPlayerName());

    }

    public void updateDrinkDisplayText(Label drinkMessageLabel) {
        drinkMessageLabel.setText(model.getCurrentPlayerDrinkText());
    }

    public void updateCurrentPlayerTexts(){
        //setCurrentPlayerLabel();
        //updateDrinkDisplayText();
    }

    public void choosePlayer(IPlayer player){
        Players.getInstance().setCurrentPlayer(player);

    }

    public void displayDrinkImage(AnchorPane drinkMessagePane){
        drinkMessagePane.toFront();
    }


    public void populatePlayerList(ListView<String> listView){
        listView.getItems().clear();
        for(IPlayer player : Players.getInstance().getPlayersList()) {
            listView.getItems().add(player.getName());
        }

    }

    public void selectPlayer(ListView<String> listView){
        String name = listView.getSelectionModel().getSelectedItem();
        IPlayer selectedPlayer = Players.getInstance().getPlayer(name);
        displaySelectedPlayer(name, selectedPlayersListView);

    }

    public void displaySelectedPlayer(String name, ListView<String> playersListView) {
        playersListView.getItems().add(name);

    }



    public void startDropTimer(AnchorPane drinkMessagePane) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                displayDrinkImage(drinkMessagePane);}
        };
        long delay = 225;
        timer.schedule(task, delay);
    }



}

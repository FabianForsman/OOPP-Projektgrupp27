package View;

import Controllers.TremanController;
import Model.Player.Players;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Random;

public class TremanView extends AbstractGameView{

    private TremanController controller;
    Random random = new Random();

    @FXML private ListView<String> playerListView;
    @FXML private ListView<String> selectedPlayersListView;

    @FXML private Button challengeRollButton;
    @FXML private Button rollDiceButton;
    @FXML private Button confirmSelectedPlayersButton;
    @FXML private Button removePlayersButton;
    @FXML private Button addPlayerButton;

    @FXML private ImageView diceRightTremanImageView;
    @FXML private ImageView diceLeftTremanImageView;
    @FXML private ImageView diceTremanMenuButtonImageView;
    @FXML private ImageView topLeftDice;
    @FXML private ImageView firstDieImage;
    @FXML private ImageView secondDieImage;
    @FXML private Label challengeLabel;

    @FXML private Label currentTremanLabel;
    @FXML private Label currentPlayerLabel;
    @FXML private Label actionMessageLabel;

    public TremanView(TremanController controller) throws IOException {
        super(controller.getFXMLName());
        this.controller = controller;
        initialize();
    }

    private void initialize() {
        controller.initializeLabels(currentTremanLabel, currentPlayerLabel, actionMessageLabel);
        controller.initializeButtons(challengeRollButton, rollDiceButton, confirmSelectedPlayersButton, removePlayersButton, addPlayerButton);
        controller.initializeListViews(playerListView, selectedPlayersListView);
        controller.displaySelectedPlayer(Players.getInstance().getCurrentPlayerName(), currentPlayerLabel);
        controller.displaySelectedPlayer(controller.getTremanName(), currentTremanLabel);
    }

    @Override
    public void update() {
        controller.setNormalRollingStatus();
        controller.populatePlayerList(playerListView);
    }

    @FXML
    public void roll(ActionEvent e) {
        controller.roll(diceLeftTremanImageView, diceRightTremanImageView);
        controller.setFirstDieImage(diceLeftTremanImageView);
        controller.setSecondDieImage(diceRightTremanImageView);
    }

    @FXML
    public void rollDieChallenge(ActionEvent e) {
        controller.rollDieChallenge(1);
        controller.setSecondDieImage(diceRightTremanImageView);
    }

    @FXML
    public void selectPlayer(ActionEvent e) {
        controller.selectPlayer(playerListView);
    }

    @FXML
    public void removePlayer(ActionEvent e) {
        controller.removePlayer(selectedPlayersListView);
    }

    @FXML
    public void confirmSelectedPlayers() {
        controller.confirmSelectedPlayers();
    }


}

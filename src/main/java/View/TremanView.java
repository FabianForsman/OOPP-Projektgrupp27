package View;

import Controllers.Treman.TremanController;
import Model.Player.Players;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Random;

public class TremanView extends AbstractView{



    private TremanController controller;
    private FXMLLoader fxmlLoader;
    Random random = new Random();

    @FXML public AnchorPane tremanGameAnchorPane;
    @FXML public  ImageView diceRightTremanImageView;
    @FXML public  ImageView diceLeftTremanImageView;

    @FXML public ImageView diceTremanMenuButtonImageView;
    @FXML public Label challengeLabel;

    @FXML public ListView<String> playerListView;
    @FXML public ListView<String> selectedPlayersListView;

    @FXML public Button tremanRollButton;
    @FXML public Button challengeRollButton;
    @FXML public Button rollDiceButton;
    @FXML public AnchorPane playerListPane;
    @FXML public AnchorPane boardPane;

    @FXML public ImageView topLeftDice;
    @FXML public ImageView firstDieImage = new ImageView();
    @FXML public ImageView secondDieImage;

    @FXML public Label currentTremanLabel;
    @FXML public Label currentPlayerLabel;
    @FXML public Label actionMessageLabel;

    public TremanView(TremanController controller) throws IOException {
        super(controller.getFXMLName());
        this.controller = controller;
        initialize();
    }

    private void initialize() {
        controller.initializeLabels(currentTremanLabel, currentPlayerLabel, actionMessageLabel);
        controller.populatePlayerList(playerListView);
        setPlayerLabel(Players.getInstance().getCurrentPlayerName(), currentPlayerLabel);
        setPlayerLabel(controller.getTremanName(), currentTremanLabel);

    }

    @FXML
    public void roll(ActionEvent e) {
        controller.roll(diceLeftTremanImageView, diceRightTremanImageView);
        controller.setFirstDieImage(diceLeftTremanImageView);
        controller.setSecondDieImage(diceRightTremanImageView);
    }

    public void setPlayerLabel(String name, Label label){
        controller.displaySelectedPlayer(name, label);
    }

    @FXML
    public void selectPlayer(ActionEvent e) {
        controller.selectPlayer(playerListView);
    }

    @FXML
    public void removeSelectedPlayers(ActionEvent e){
        controller.removeSelectedPlayers(selectedPlayersListView);
    }

    @FXML
    public void displayChallengeButton(ActionEvent e){
        controller.displayChallengeButton(challengeRollButton);
    }

    @FXML
    public void removeChallengeButton(ActionEvent e){
        controller.removeChallengeButton(challengeRollButton);
    }
}

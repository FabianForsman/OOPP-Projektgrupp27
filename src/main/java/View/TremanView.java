
package View;

import Controllers.TremanController;
import Model.Player.Players;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Random;

public class TremanView extends AbstractGameView{

    private final TremanController controller;
    Random random = new Random();

    @FXML private AnchorPane startGameAnchorPane;

    @FXML private ListView<String> playerListView;
    @FXML private ListView<String> selectedPlayersListView;

    @FXML private Button challengeRollButton;
    @FXML private Button rollDiceButton;
    @FXML private Button confirmSelectedPlayersButton;
    @FXML private Button removePlayersButton;
    @FXML private Button addPlayerButton;
    @FXML private Button startGameButton;

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

    /**
     * Constructor for TremanView. Passes the controllers name to AbstractGameView.
     * @param controller
     * @throws IOException
     */
    public TremanView(TremanController controller) throws IOException {
        super(controller.getFXMLName());
        this.controller = controller;
        initialize();
    }

    /**
     * Passes the labels, buttons and listviews to the controller so that it can take inputs and manipulate them.
     */
    private void initialize() {
        controller.initializeLabels(currentTremanLabel, currentPlayerLabel, actionMessageLabel);
        controller.initializeButtons(challengeRollButton, rollDiceButton, confirmSelectedPlayersButton, removePlayersButton, addPlayerButton);
        controller.initializeListViews(playerListView, selectedPlayersListView);
        //controller.displaySelectedPlayer(Players.getInstance().getCurrentPlayerName(), currentPlayerLabel);
        //controller.displaySelectedPlayer(controller.getTremanName(), currentTremanLabel);
    }

    @Override
    public void update() {
        controller.setNormalRollingStatus();
        controller.populatePlayerList(playerListView);
    }

    /**
     * Roll-dice button. Uses the controllers roll-functionality and sets the images accordingly.
     * @param e
     */
    @FXML
    public void roll(ActionEvent e) {
        controller.roll(diceLeftTremanImageView, diceRightTremanImageView);
        controller.setFirstDieImage(diceLeftTremanImageView);
        controller.setSecondDieImage(diceRightTremanImageView);
    }

    /**
     * Roll-die button. Uses the controllers roll-die-functionality and sets the image accordingly.
     * @param e
     */
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

    @FXML
    public void startGame() {
        startGameAnchorPane.setVisible(false);
        startGameButton.setVisible(false);
        controller.updatePlayerLabels();
    }
}

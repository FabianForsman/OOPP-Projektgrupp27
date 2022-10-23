package View;

import Model.DiceGames.Opus.OpusController;
import Model.Player.IPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class OpusView {

    private OpusController controller;

    @FXML private Button rollDiceButton;
    @FXML private Button opusGameStartButton;
    @FXML private ListView<IPlayer> playerList;
    @FXML private AnchorPane drinkMessagePane;
    @FXML private Label drinkMessageLabel;
    @FXML private Label currentPlayerLabel;
    @FXML private ImageView diceImageView;

    @FXML
    public void roll(ActionEvent e) {
        controller.roll(diceImageView);
        //setImage
    }


}

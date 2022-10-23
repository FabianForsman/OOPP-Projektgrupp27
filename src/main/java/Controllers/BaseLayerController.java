package Controllers;

import Model.DiceGames.Treman.TremanModel;
import Model.Player.IPlayer;
import Model.Player.Players;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BaseLayerController {
    SceneHandler handler;
    Players playerList;

    @FXML private Button startGameButton, addButton, removeButton;
    @FXML private Label chooseGameLabel;
    @FXML private AnchorPane rootAnchorPane;
    @FXML private TextField playerNameTextField;




    public BaseLayerController(SceneHandler handler) {
        this.handler = handler;
    }

    public String getFXMLName() {
        return "base-layer";
    }


    public void openChooseGame() {
        handler.switchTo("GameChoose");
    }

    public void addPlayer(ListView playerListView, IPlayer playerName){
        playerList.addPlayer(playerName);
        playerListView.getItems().add(playerName);

    }

}

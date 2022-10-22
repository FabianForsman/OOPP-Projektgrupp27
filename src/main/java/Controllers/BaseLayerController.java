package Controllers;

import Model.DiceGames.Treman.TremanModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BaseLayerController {
    SceneHandler handler;

    @FXML private Button startGameButton, addButton, removeButton;
    @FXML private Label chooseGameLabel;
    @FXML private AnchorPane rootAnchorPane;
    @FXML private TextField playerNameTextField;
    @FXML private ListView playerListView;



    public BaseLayerController(SceneHandler handler) {
        this.handler = handler;
    }

    public String getFXMLName() {
        return "base-layer";
    }


    public void openChooseGame() {
        handler.switchTo("GameChoose");
    }

}

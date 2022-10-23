package Controllers;

import Model.Game;
import Model.Player.IPlayer;
import Model.Player.Player;
import Model.Player.Players;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;

public class BaseLayerController implements IController {
    SceneHandler handler;

    private Button addButton, removeButton;
    private Label chooseGameLabel;
    private AnchorPane rootAnchorPane;
    private TextField playerNameTextField;
    private ListView playerListView;

    private Button startGameButton;


    public BaseLayerController(SceneHandler handler) {
        this.handler = handler;
    }

    public void initializeButtons(Button startGameButton) {
        this.startGameButton = startGameButton;
    }

    @Override
    public String getFXMLName() {
        return "base-layer";
    }


    public void openChooseGame() {
        handler.switchToMenu("GameChoose");
    }


    public void addPlayer(ListView<String> playerListView, TextField playerName){
        String name = playerName.getText();
        int playerListSize = Players.getInstance().getListSize();
        if(name.equals("")) {
            playerName.setText("Enter a name!");
        } else if (playerListSize < Game.getMaxPlayers()){
            if(!playerListView.getItems().contains(name)){
                playerListView.getItems().add(name);
                Players.getInstance().addPlayer(new Player(name));
            } else {
                playerName.setText("Player already exists, try again");
            }
        }
    }

    public void removeSelectedPlayer(ListView<String> playerListView){
        String playerName = playerListView.getSelectionModel().getSelectedItem();
        IPlayer selectedPlayer = Players.getInstance().getPlayer(playerName);
        playerListView.getItems().remove(playerName);

        Players.getInstance().removePlayer(selectedPlayer);
    }



    public void checkIfPlayerAmountAllowed(){
        int playerListSize = Players.getInstance().getListSize();
        if(playerListSize >= Game.getMinPlayers()){
            startGameButton.setVisible(true);
            startGameButton.setDisable(false);
        }
    }


}
